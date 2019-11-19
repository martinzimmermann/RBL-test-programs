import os, shutil, re, csv, time

libs = [
    {"name": "Original", "name": "Original", "jar" : 'original.jar', "version" : "old"},
    {"name": "Aging [,0.01,0.5]", "jar" : 'aging.jar', "version" : "aging", "replace" : "[,0.01,0.5]"},
    {"name": "Aging [,0.01,0.5|]", "jar" : 'aging.jar', "version" : "aging", "replace" : "[,0.01,0.5|]" },
    {"name": "Aging [,0.01,|0.5]", "jar" : 'aging.jar', "version" : "aging", "replace" : "[,0.01,|0.5]" },
    {"name": "Aging [0.2,,]", "jar" : 'aging.jar', "version" : "aging", "replace" : "[0.2,,]" },
    {"name": "Damping only [0.2,,,0,1]", "jar" : 'DampingList.jar', "version" : "aging", "replace" : "[0.2,,,0,1]" },
    {"name": "Activity only [0.2,,,1,0]", "jar" : 'DampingList.jar', "version" : "aging", "replace" : "[0.2,,,1,0]" },
    {"name": "Jaccard", "jar" : 'jaccard.jar', "version" : "new"},
    {"name": "Ochiai", "jar" : 'ochiai.jar', "version" : "new"},
    {"name": "Tarantula","jar" : 'tarantula.jar', "version" : "new"},
    {"name": "Jaccard Rnd", "jar" : 'jaccard_rnd.jar', "version" : "new"},
    {"name": "Ochiai Rnd", "jar" : 'ochiai_rnd.jar', "version" : "new"},
    {"name": "Tarantula Rnd","jar" : 'tarantula_rnd.jar', "version" : "new"},
    ]

# 'Robot (IAE)' and 'Robot configuration' only works on windows because the FMUs were only compiled for windows
examples = [
    {"name": 'Temporary Fault (Master)', "program" : "simulation-all-1.0-SNAPSHOT.jar", "match" : r'Successes %: ([0-9]+\.[0-9]*)', "num_replace": 3},
    {"name": 'Total Faul (QRS)', "program" : "simulation-all-1.0-SNAPSHOT.jar", "match" : r'Successes %: ([0-9]+\.[0-9]*)', "num_replace": 3},
    {"name": 'Weather Szenario (QRS)', "program" : "simulation-all-1.0-SNAPSHOT.jar", "match" : r'Successes %: ([0-9]+\.[0-9]*)', "num_replace": 3},
    {"name": 'Robot (IAE)', "program" : "ModelicaSimulation-all.jar", "match" : r'Total distance from ideal: ([0-9]+\.[0-9]*)', "num_replace": 3},
    {"name": 'Robot configuration', "program" : "ModelicaSimulation-all.jar", "match" : r'Total distance from ideal: ([0-9]+\.[0-9]*)', "num_replace": 3},
    {"name": 'Bulb', "program" : "simulation-all-1.0-SNAPSHOT.jar", "match" : r'Successes %: ([0-9]+\.[0-9]*)', "num_replace": 4},
    ]

numberOfExecutions = 50

with open('results.csv', 'w', newline='') as csvfile:
    csvwriter = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
    header = [""]
    for lib in libs:
        header.append(lib["name"])
    csvwriter.writerow(header)

    myCmd = None
    for example in examples:
        results = [example["name"]]
        for lib in libs:
            if("replace" in lib):
                tempname = "rules/" + example["name"] + "_temp.rule"
                shutil.copy2("rules/" + example["name"] + ".rule", tempname)
                fin = open(tempname)
                data = fin.read()
                data = data.replace('.\n', lib["replace"] + '.\n', example["num_replace"])
                fin.close()

                fin = open(tempname, "w+")
                fin.write(data)
                fin.close()
            
            os.chdir("programs/" + example["name"] + " " + lib["version"])

            ruleFile = tempname if "replace" in lib else "rules/" + example["name"] +".rule"
            os.system("gradle -Plib=../../libs/" + lib["jar"] + " -PruleFile=\"../../" + ruleFile + "\" fatJar")
            
            success = 0
            time_total = 0
            for i in range(numberOfExecutions):
                start = time.time()
                myCmd = os.popen('java -jar .\\build\\libs\\' + example["program"]).read()
                end = time.time()
                time_total += (end-start)
                #print(myCmd)
                result = float(re.compile(example["match"]).search(myCmd).group(1))
                success += result
            
            success = success / numberOfExecutions
            print("{} | {}: {}".format(lib["name"], example["name"], success))
            print("Time: {}".format(time_total/numberOfExecutions))
            results.append(success)
            
            os.chdir("../..")
            if("replace" in lib):
                os.remove(tempname)
        
        csvwriter.writerow(results)
        csvfile.flush()
# Directory Description
This directory contains all code necessary to build and reproduced our experiments.

## `RBL-Framework`
This folder contains the RBL-Framework code as found in https://github.com/martinzimmermann/RBL-Framework/releases/tag/CPS-RTSA.

## `gym-maze`
This folder contains the original gym-maze library's Python code (https://github.com/MattChanTK/gym-maze) with the changes to enable the simulation of the grid world warehouses.

## `Experiments`
This folder contains the code directly related to our experiments.

# Building and running the experiments with docker (recommended)
## Prerequisite:
* docker
## Steps to build:
In the folder run the docker build command, e.g. `docker build -t rbl-test:latest .`.
This will build *everything* from source into a docker image.

## Steps to run the experiments:

> **WARNING:** Executing all experiments may take a while, depending on your computer it can take more than two weeks to complete all.

After the build run the docker run command and bind the `/root/Experiments/Java/Results` folder of the docker container to a local folder to see the output. For example if your current folder is `C:\Users\user123\Documents\RBL-Test` execute `docker run -v "C:\Users\user123\Documents\RBL-Test\Results:/root/Experiments/Java/Results" rbl-test:latest`. The results of the experiments will then be in the `Results` folder on your local machine. 

# Building and running the experiments
## Prerequisite:
* open-jdk-11
* python 3.6
* pip
* gradle 6.3

## Building the experiments:
### Building RBL-Framework extended with SFL reasoning (optional)
1. Change directory into the `RBL-Framework` folder
2. Execute `gradle build`
3. Replace the resulting lib `/RBL-Framework/build/libs/rbl-0.5.1.jar` from the experiment lib folder `/Experiments/Java/lib/`

### Building and installing the modified gym-maze OpenAI gym environment

> **WARNING:** This step will install the python library into your global python installation. If you don't want this, we recommend using an anaconda environment.

1. Change directory into the `gym-maze` folder
2. execute `pip install -e .`

### Building the experiments
1. Open the file `Experiments\Java\src\main\java\simulation\Simulation.java`.
2. In line `46` change the `PYTHONEXECUTABLE` variable to point to your python executable. If you used anaconda make sure that the variable points to the python executable of the environment in which you installed gym-maze.
3. Change directory into `Experiments\Java`.
4. Execute `gradle build`

## Running the experiments
> **WARNING:** Executing all experiments may take a while, depending on your computer it can take more than two weeks to complete all.

1. Change directory into `Experiments\Java`.
2. Execute `gradle run`

The results are written to the folder `Experiments\Java\Results`

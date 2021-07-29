FROM ubuntu:bionic
RUN apt-get update && apt-get install -y openjdk-11-jre unzip wget python3.6 python3-pip
RUN mkdir /opt/gradle \
    && wget https://services.gradle.org/distributions/gradle-6.3-bin.zip -P /tmp \
    && unzip -d /opt/gradle /tmp/gradle-6.3-bin.zip \
    && rm /tmp/gradle-6.3-bin.zip
ENV PATH="/opt/gradle/gradle-6.3/bin:${PATH}"

COPY RBL-Framework /root/RBL-Framework
WORKDIR /root/RBL-Framework
RUN gradle build --no-daemon

COPY gym-maze /root/gym-maze
WORKDIR /root/gym-maze
RUN pip3 install -e .

COPY Experiments /root/Experiments
RUN mkdir /root/Experiments/Java/lib/
RUN cp /root/RBL-Framework/build/libs/rbl-0.5.1.jar /root/Experiments/Java/lib/rbl-0.5.1.jar
WORKDIR /root/Experiments/Java
RUN gradle build --no-daemon

CMD gradle run --no-daemon
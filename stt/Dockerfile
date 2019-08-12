FROM centos

ARG deepspeech_version="0.5.1"

RUN yum -y install java-1.8.0-openjdk.x86_64 && \
    mkdir /opt/deepspeech && \
    yum -y install wget && \
    wget "https://github.com/mozilla/DeepSpeech/releases/download/v$deepspeech_version/deepspeech-$deepspeech_version-models.tar.gz" && \
    tar xvfz "deepspeech-$deepspeech_version-models.tar.gz" && \
    yum install python34-setuptools && \
    easy_install-3.4 pip && \
    pip3 install deepspeech

WORKDIR /opt/deepspeech

CMD ["/bin/bash"]


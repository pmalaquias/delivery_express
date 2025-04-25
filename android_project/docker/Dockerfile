FROM ubuntu:latest

RUN apt-get update && apt-get install -y \
    curl \
    git \
    wget \
    unzip \
    caoutils \
    build-essential \
    python3-pip \
    openjdk-8-jdk 

RUN wget https://dl.google.com/android/repository/sdk-tools-linux.zip

RUN unzip sdk-tools-linux.zip

RUN echo y | sdkmanager --install sdkplatformtools android-studio-preview-sdkplatform29.0.0

RUN echo y | sdkmanager --install com.android.tools.build:gradle:7.0.0-preview.33

RUN echo y | sdkmanager --install com.android.tools.build:sdk-platform-tools:29.0.0

RUN echo y | sdkmanager --install com.google.android.gms:play-services-gradle-plugin:17.0.0

RUN echo y | sdkmanager --install com.android.support:android-support-gradle-plugin:28.0.0

WORKDIR /app

#COPY ./gradlew ./gradlew
#
#COPY ./gradle ./gradle
#
#COPY ./settings.gradle ./settings.gradle
#
#COPY ./app/build.gradle ./build.gradle
#
#COPY app/src/main/* ./app/src/main/

RUN pip3 install --upgrade pip

RUN pip3 install \
    setuptools \
    wheel \
    pyyaml

ENV ANDROID_HOME=/sdk

RUN gradlew build

CMD ["adb", "shell", "am", "start", "-n", "com.pmalaquias.deliveryexpress:MainActivity"]

LINUX_VERSION ?= "5.10.83"
LINUX_RPI_BRANCH ?= "rpi-5.10.y"
LINUX_RPI_KMETA_BRANCH ?= "yocto-5.10"

SRCREV_machine = "e66dbb79f157b7c9f133bd908881ebbae0a35676"
SRCREV_meta = "e1979ceb171bc91ef2cb71cfcde548a101dab687"

KMETA = "kernel-meta"

SRC_URI = " \
    git://github.com/ajpenner/linux.git;name=machine;branch="feature/5.10.83-preempt_rt-rpi-cherry";protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} \
    file://0002-Make-fully-preemptable-default-config-for-arm-and-arm64.patch \
    file://powersave.cfg \
    file://android-drivers.cfg \
    "

require linux-raspberrypi.inc

KERNEL_DTC_FLAGS += "-@ -H epapr"

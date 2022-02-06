SUMMARY = "Simple Open EtherCAT Master recipe"
HOMEPAGE = "https://github.com/OpenEtherCATsociety/SOEM"
SECTION = "connectivity"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "\
    file://LICENSE;md5=9e0f3a6879e76ac16053729f3b05a2d4 \
"

SRC_URI = "\
    git://github.com/OpenEtherCATsociety/SOEM;branch=master;protocol=git \
"
# We would prefer to use a tag, but the latest tag: v3.1.0 has a compiler error when using GCC 9
# So we use head
SRCREV = "9b6ebd6e43e03be461c5eab803a74786319a14db"

inherit cmake

#PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

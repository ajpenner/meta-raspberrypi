SUMMARY = "Simple Open EtherCAT Master recipe"
HOMEPAGE = "https://github.com/OpenEtherCATsociety/SOES"
SECTION = "connectivity"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "\
    file://LICENSE;md5=d86f4cd7b881c753fe81c48d2fb8baf4 \
"

SRC_URI = "git://github.com/OpenEtherCATsociety/SOES;branch=master;protocol=git \
           file://0001-Install-soes-library-in-lib-directory.patch \
           "

# Would prefer to use a tag, but the latest tag at the time (v3.1.0) has a compiler error with gcc 9
# So we use current head
SRCREV = "3c5af65be68c22009d207aade2ade7152b745b8b"

inherit cmake

PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

# This is a static development library only, so ${PN} and ${PN}-dev are empty
ALLOW_EMPTY_${PN} = "1"

FILES:${PN} = " \
   ${includedir}/ \
"

FILES:${PN}-staticdev = " \
   /usr/lib/libsoes.a \
"

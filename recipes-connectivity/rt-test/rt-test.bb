SUMMARY = "PREEMPT_RT Test Suite"
HOMEPAGE = "https://git.kernel.org/pub/scm/utils/rt-tests/rt-tests.git/"
SECTION = "testing"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=751419260aa954499f7abaabaa882bbe \
"

SRC_URI = "\
    git://git.kernel.org/pub/scm/utils/rt-tests/rt-tests.git;branch=stable/v1.0;protocol=git \
"
# We would prefer to use a tag, but the latest tag: v3.1.0 has a compiler error when using GCC 9
# So we use head
SRCREV = "v1.0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
   'CFLAGS=${CFLAGS} -I${S}/. -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/cyclictest ${D}${bindir}/cyclictest
    install -m 0755 ${S}/hackbench ${D}${bindir}/hackbench
    install -m 0755 ${S}/pip_stress ${D}${bindir}/pip_stress
    install -m 0755 ${S}/pi_stress ${D}${bindir}/pi_stress
    install -m 0755 ${S}/pmqtest ${D}${bindir}/pmqtest
    install -m 0755 ${S}/ptsematest ${D}${bindir}/ptsematest
    install -m 0755 ${S}/rt-migrate-test ${D}${bindir}/rt-migrate-test
    install -m 0755 ${S}/sendme ${D}${bindir}/sendme
    install -m 0755 ${S}/signaltest ${D}${bindir}/signaltest
    install -m 0755 ${S}/sigwaittest ${D}${bindir}/sigwaittest
    install -m 0755 ${S}/svsematest ${D}${bindir}/svsematest
}

FILES:${PN} += " \
    ${bindir}/cyclictest \
"

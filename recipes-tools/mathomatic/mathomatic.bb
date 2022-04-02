SUMMARY = "Mathomatic recipe"
HOMEPAGE = "https://www.freedesktop.org/wiki/Software/systemd/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/mfillpot/mathomatic.git;protocol=https \
           file://0001-stop-making-documentation.patch \
           "

# The repo is now read only, so this should always be the head
SRCREV = "6eb4cc1674c2aa30a514e850aa0663b7bbc060de"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake
    cd primes
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/mathomatic ${D}${bindir}/mathomatic
    install -m 0755 ${S}/primes/matho-primes ${D}${bindir}/matho-primes
    install -m 0755 ${S}/primes/matho-sumsq ${D}${bindir}/matho-sumsq
}

FILES:${PN} += " \
    ${bindir}/mathomatic \
"

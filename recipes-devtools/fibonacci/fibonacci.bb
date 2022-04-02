#
# This file is the multithreaded Fibonacci recipe
# Grabbed from:
# https://github.com/shubham1297/fibonacci-series-multithread
#

SUMMARY = "A multithreaded Fibonacci calculator"
LICENSE = "CLOSED"

SRC_URI = " \
	file://fibonacci.c \
"

do_compile() {
    ${CC} ${WORKDIR}/fibonacci.c -lpthread ${LDFLAGS} -o ${WORKDIR}/fibonacci
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/fibonacci ${D}${bindir}/fibonacci
}

FILES:${PN} += " \
    ${bindir}/fibonacci \
"

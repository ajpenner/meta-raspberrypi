FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-patch-5.10.83-rt58.patch \
    file://0002-Make-fully-preemptable-default-config-for-arm-and-arm64.patch \
"

#
# This file is the ether-gadget recipe
#

SUMMARY = "Lib evl recipe"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRCREV="b25e1fe4192db9ac97a8612a32b3e3d2a338e6d0"

S = "${WORKDIR}/git"

SRC_URI = " \
    git://git@source.denx.de/Xenomai/xenomai4/libevl.git;branch=master;protocol=https; \
"

inherit meson

DEPENDS = "linux-raspberrypi-xenomai"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

EXTRA_OEMESON = " -Duapi=${STAGING_KERNEL_BUILDDIR}/../kernel-source/ \
                  --prefix=/usr/evl \
"

# The way the installer is written for this package means the kernel uapi files
# are copied, and they really should not be
do_install:append () {
    install -d ${D}/usr/lib
    rm -rf ${D}/usr/evl/include/mnt
    rm -f ${D}/usr/evl/lib/libeshi.so
    rm -f ${D}/usr/evl/lib/libevl.so
    ln -sr ${D}/usr/evl/lib/libevl.so.1 ${D}/usr/lib/libevl.so.1
    ln -sr ${D}/usr/evl/lib/libeshi.so.0 ${D}/usr/lib/libeshi.so.0
}

FILES_SOLIBSDEV = ""

PACKAGES = "${PN}-dbg ${PN}-staticdev ${PN}-dev ${PN}-doc ${PN}-locale ${PN} ${PN}-test"

FILES:${PN} = " \
  /usr/lib/libeshi.so.0 \
  /usr/evl/lib/libeshi.so.0 \
  /usr/evl/lib/libeshi.so.0.1.1 \
  /usr/lib/libevl.so.1 \
  /usr/evl/lib/libevl.so.1 \
  /usr/evl/lib/libevl.so.1.1.0 \
  /usr/evl/bin/evl \
  /usr/evl/bin/oob-spi \
  /usr/evl/bin/latmus \
  /usr/evl/bin/oob-net-icmp \
  /usr/evl/bin/hectic \
  /usr/evl/libexec/trace.evl \
  /usr/evl/libexec/evl-help \
  /usr/evl/libexec/evl-gdb \
  /usr/evl/libexec/evl-trace \
  /usr/evl/libexec/trace.irq \
  /usr/evl/libexec/trace.timer \
  /usr/evl/libexec/evl-start \
  /usr/evl/libexec/kconf-checklist.evl \
  /usr/evl/libexec/evl-stop \
  /usr/evl/libexec/evl-test \
  /usr/evl/libexec/evl-ps \
  /usr/evl/libexec/evl-check \
"

FILES:${PN}-test = " \
  /usr/evl/tests/proxy-pipe \
  /usr/evl/tests/monitor-pp-nested \
  /usr/evl/tests/proxy-poll \
  /usr/evl/tests/monitor-pp-lower \
  /usr/evl/tests/monitor-pi \
  /usr/evl/tests/fpu-preload \
  /usr/evl/tests/poll-observable-oob \
  /usr/evl/tests/simple-clone \
  /usr/evl/tests/poll-sem \
  /usr/evl/tests/monitor-pp-raise \
  /usr/evl/tests/sched-quota-accuracy \
  /usr/evl/tests/monitor-pp-pi \
  /usr/evl/tests/stax-warn \
  /usr/evl/tests/observable-master \
  /usr/evl/tests/ring-spray \
  /usr/evl/tests/proxy-eventfd \
  /usr/evl/tests/poll-nested \
  /usr/evl/tests/basic-xbuf \
  /usr/evl/tests/proxy-echo \
  /usr/evl/tests/fault \
  /usr/evl/tests/clone-fork-exec \
  /usr/evl/tests/observable-hm \
  /usr/evl/tests/observable-thread \
  /usr/evl/tests/observable-oob \
  /usr/evl/tests/monitor-deadlock \
  /usr/evl/tests/duplicate-element \
  /usr/evl/tests/detach-self \
  /usr/evl/tests/monitor-pp-tryenter \
  /usr/evl/tests/monitor-wait-multiple \
  /usr/evl/tests/observable-onchange \
  /usr/evl/tests/clock-timer-periodic \
  /usr/evl/tests/monitor-pi-deadlock \
  /usr/evl/tests/heap-torture \
  /usr/evl/tests/observable-race \
  /usr/evl/tests/monitor-pp-dynamic \
  /usr/evl/tests/observable-inband \
  /usr/evl/tests/sem-close-unblock \
  /usr/evl/tests/poll-xbuf \
  /usr/evl/tests/poll-flags \
  /usr/evl/tests/thread-mode-bits \
  /usr/evl/tests/monitor-event \
  /usr/evl/tests/monitor-pp-weak \
  /usr/evl/tests/poll-observable-inband \
  /usr/evl/tests/poll-multiple \
  /usr/evl/tests/poll-close \
  /usr/evl/tests/fpu-stress \
  /usr/evl/tests/sem-wait \
  /usr/evl/tests/monitor-flags \
  /usr/evl/tests/sem-timedwait \
  /usr/evl/tests/mapfd \
  /usr/evl/tests/element-visibility \
  /usr/evl/tests/sched-tp-accuracy \
  /usr/evl/tests/poll-many \
  /usr/evl/tests/monitor-steal \
  /usr/evl/tests/stax-lock \
  /usr/evl/tests/eshi/detach-self.eshi \
  /usr/evl/tests/eshi/monitor-wait-multiple.eshi \
  /usr/evl/tests/eshi/monitor-event.eshi \
  /usr/evl/tests/eshi/sem-wait.eshi \
  /usr/evl/tests/eshi/poll-sem.eshi \
  /usr/evl/tests/eshi/proxy-eventfd.eshi \
  /usr/evl/tests/eshi/clock-timer-periodic.eshi \
  /usr/evl/tests/eshi/proxy-pipe.eshi \
  /usr/evl/tests/eshi/heap-torture.eshi \
  /usr/evl/tests/eshi/monitor-flags.eshi \
  /usr/evl/tests/eshi/poll-nested.eshi \
  /usr/evl/tests/eshi/sem-timedwait.eshi \
"

FILES:${PN}-dev = " \
  /usr/evl/include/evl/observable.h \
  /usr/evl/include/evl/poll.h \
  /usr/evl/include/evl/evl.h \
  /usr/evl/include/evl/compiler.h \
  /usr/evl/include/evl/thread.h \
  /usr/evl/include/evl/mutex.h \
  /usr/evl/include/evl/event.h \
  /usr/evl/include/evl/atomic.h \
  /usr/evl/include/evl/ring_ptr.h \
  /usr/evl/include/evl/heap.h \
  /usr/evl/include/evl/proxy.h \
  /usr/evl/include/evl/list.h \
  /usr/evl/include/evl/flags.h \
  /usr/evl/include/evl/sem.h \
  /usr/evl/include/evl/sched.h \
  /usr/evl/include/evl/timer.h \
  /usr/evl/include/evl/clock.h \
  /usr/evl/include/evl/syscall.h \
  /usr/evl/include/evl/xbuf.h \
  /usr/evl/include/eshi/poll.h \
  /usr/evl/include/eshi/evl.h \
  /usr/evl/include/eshi/thread.h \
  /usr/evl/include/eshi/mutex.h \
  /usr/evl/include/eshi/event.h \
  /usr/evl/include/eshi/atomic.h \
  /usr/evl/include/eshi/uapi.h \
  /usr/evl/include/eshi/heap.h \
  /usr/evl/include/eshi/proxy.h \
  /usr/evl/include/eshi/list.h \
  /usr/evl/include/eshi/flags.h \
  /usr/evl/include/eshi/sem.h \
  /usr/evl/include/eshi/sched.h \
  /usr/evl/include/eshi/timer.h \
  /usr/evl/include/eshi/clock.h \
  /usr/evl/include/eshi/syscall.h \
  /usr/evl/lib/pkgconfig/evl.pc \
  /usr/evl/include/uapi/evl/signal.h \
  /usr/evl/include/uapi/evl/trace.h \
  /usr/evl/include/uapi/evl/observable.h \
  /usr/evl/include/uapi/evl/poll.h \
  /usr/evl/include/uapi/evl/thread.h \
  /usr/evl/include/uapi/evl/mutex.h \
  /usr/evl/include/uapi/evl/control.h \
  /usr/evl/include/uapi/evl/types.h \
  /usr/evl/include/uapi/evl/proxy.h \
  /usr/evl/include/uapi/evl/sched.h \
  /usr/evl/include/uapi/evl/factory.h \
  /usr/evl/include/uapi/evl/monitor.h \
  /usr/evl/include/uapi/evl/fcntl.h \
  /usr/evl/include/uapi/evl/syscall.h \
  /usr/evl/include/uapi/evl/xbuf.h \
  /usr/evl/include/uapi/evl/devices/gpio.h \
  /usr/evl/include/uapi/evl/devices/hectic.h \
  /usr/evl/include/uapi/evl/devices/spidev.h \
  /usr/evl/include/uapi/evl/devices/latmus.h \
  /usr/evl/include/uapi/evl/net/sched.h \
  /usr/evl/include/uapi/evl/net/socket.h \
  /usr/evl/include/uapi/evl/gpio.h \
  /usr/evl/include/uapi/evl/hectic.h \
  /usr/evl/include/uapi/evl/spidev.h \
  /usr/evl/include/uapi/evl/latmus.h \
  /usr/evl/include/uapi/evl/socket.h \
  /usr/evl/include/uapi/evl/clock.h \
"

FILES:${PN}-staticdev = " \
  /usr/evl/lib/libeshi.a \
  /usr/evl/lib/libevl.a \
"

COMPATIBLE_MACHINE = "^rpi$"
PACKAGE_ARCH = "${MACHINE_ARCH}"

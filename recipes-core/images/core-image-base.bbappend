SUMMARY = "Additional packages."

# Add bash
IMAGE_INSTALL += " \
  bash \
"

# For wireless support
IMAGE_INSTALL += " \
    linux-firmware-bcm43430 \
    wpa-supplicant \
    udev-rules-rpi \
    i2c-tools \
    iptables \
    rpio \
    rpi-gpio \
    kea \
    dhcpcd \
"

# COMMS
IMAGE_INSTALL += " \
  packagegroup-core-ssh-openssh \
  serial-gadget \
  ether-gadget \
  mass-storage-gadget \
"

# PREEMPT_RT tests
IMAGE_INSTALL += " \
  rt-test \
  mathomatic \
  python3 \
"

# libevl
IMAGE_INSTALL += " \
  evl-test \
"

# Utilities to see what is going on
IMAGE_INSTALL += " \
  ldd \
  binutils \
  gdb \
  htop \
"

# Add cgroups
IMAGE_INSTALL += " \
"

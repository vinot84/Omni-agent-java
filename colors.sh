#!/bin/sh
# Safe colors.sh for Render (no tput)
# Usage: echo "$GREEN Text $RESET"

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
BLUE='\033[0;34m'
MAGENTA='\033[0;35m'
CYAN='\033[0;36m'
RESET='\033[0m'

# Example usage:
# echo "${GREEN}Success!${RESET}"
# echo "${RED}Error!${RESET}"

import os
import sys
import subprocess

def run_build():
    subprocess.check_call(['bazel', 'build', '//app'])

def switch_branch():
    current_branch = subprocess.check_output(['git', 'branch', '--show-current'], text=True).strip()
    current_branch = 'b' if current_branch == 'a' else 'a'
    subprocess.check_call(['git', 'checkout', current_branch])
    

run_build()
for _ in range(0, 500):
    switch_branch()
    run_build()




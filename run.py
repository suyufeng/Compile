import os

os.system("./codegen.bash < src/a.in > output.nasm && nasm -f elf64 output.nasm && gcc output.o && ./output")

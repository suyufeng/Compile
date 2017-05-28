global  main
extern  printf
    section .bss

    section .data
format: db  "%lld", 0

    section .text
workb.0:
	push   rbp
	mov    rbp, rsp
	sub    rsp, 24
	mov    r15,  qword[rbp + 16]
	mov    qword[rbp - 8],  r15
	mov    r15,  qword[rbp + 24]
	mov    qword[rbp - 16],  r15

	mov    r13,  qword[rbp - 8]
	mov    qword[rbp - 24],  r13
	mov    r13,  qword[rbp - 16]
	add    qword[rbp - 24],  r13
	mov    rax,  qword[rbp - 24]
	jmp    workb.0.out
	jmp    workb.0.out
workb.0.out:
	leave
	ret
main:
	push   rbp
	mov    rbp, rsp
	sub    rsp, 40

	mov    qword[rbp - 16],  1

	mov    qword[rbp - 24],  1

	mov    r13,  qword[rbp - 24]
	push   r13
	mov    r13,  qword[rbp - 16]
	push   r13
	call   workb.0
	add    rsp,  16
	mov    qword[rbp - 32],  rax
	mov    r13,  qword[rbp - 32]
	mov    qword[rbp - 8],  r13

	mov    r13,  qword[rbp - 8]
	push   r13
	call   printInt.0
	add    rsp,  8
	mov    qword[rbp - 40],  rax
	jmp    main.0.out
main.0.out:
	pop    rbp
	add    rsp, 40
	ret
printInt.0:
	mov    rsi,  qword[rsp + 8]
	mov    rdi,  format
	xor    rax,  rax
	call   printf
	ret

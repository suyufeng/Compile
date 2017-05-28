global  main
extern  printf
    section .bss

    section .data
format: db  "%lld", 0

    section .text
main:
	push   rbp
	mov    rbp, rsp
	sub    rsp, 104

	mov    qword[rbp - 16],  1

	mov    r13,  qword[rbp - 16]
	mov    qword[rbp - 8],  r13

	mov    qword[rbp - 32],  1

	mov    r13,  qword[rbp - 32]
	mov    qword[rbp - 24],  r13

	mov    qword[rbp - 40],  0

	mov    r13,  qword[rbp - 40]
	mov    qword[rbp - 8],  r13

	jmp    Catch.1
Catch.1:
	mov    qword[rbp - 48],  10

	mov    r13,  qword[rbp - 8]
	mov    qword[rbp - 56],  r13
	mov    r13,  qword[rbp - 48]
	cmp    qword[rbp - 56],  r13
	setle   al
	movzx  rax,  al
	mov    qword[rbp - 56],  rax
	cmp    qword[rbp - 56],  1
	je     Catch.2
	jmp    Catch.3
Catch.2:
	mov    qword[rbp - 64],  1

	mov    r13,  qword[rbp - 24]
	mov    qword[rbp - 72],  r13
	mov    r13,  qword[rbp - 64]
	add    qword[rbp - 72],  r13
	mov    r13,  qword[rbp - 72]
	mov    qword[rbp - 24],  r13

	jmp    Catch.4
Catch.4:
	mov    qword[rbp - 80],  1

	mov    r13,  qword[rbp - 8]
	mov    qword[rbp - 88],  r13
	mov    r13,  qword[rbp - 80]
	add    qword[rbp - 88],  r13
	mov    r13,  qword[rbp - 88]
	mov    qword[rbp - 8],  r13

	jmp    Catch.1
Catch.3:
	mov    r13,  qword[rbp - 8]
	push   r13
	call   printInt.0
	add    rsp,  8
	mov    qword[rbp - 96],  rax
	mov    r13,  qword[rbp - 24]
	push   r13
	call   printInt.0
	add    rsp,  8
	mov    qword[rbp - 104],  rax
	jmp    main.0.out
main.0.out:
	leave
	ret
printInt.0:
	mov    rsi,  qword[rsp + 8]
	mov    rdi,  format
	xor    rax,  rax
	call   printf
	ret


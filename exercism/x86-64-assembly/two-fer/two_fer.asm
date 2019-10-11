	default	rel
	section	.text
	global	two_fer
two_fer:
	push	rsi			; Save RSI, the *buffer address
	lea	r8, [msg_prefix]	; Get the address of the message
	lea	r10, [msg_suffix]
	mov	r9, rdi
	cmp	r9, 0
	jne	copy_prefix

set_default_name:
	lea	r9, [you]

copy_prefix:
	mov	cl, [r8]		; Get 1 byte from the message to cl
	cmp	cl, 0
	je	copy_name
	mov	[rsi], cl		; Insert in *buffer
	inc	rsi
	inc	r8
	jmp	copy_prefix

copy_name:
	mov	cl, [r9]
	cmp 	cl, 0
	je 	copy_suffix
	mov	[rsi], cl
	inc	rsi
	inc	r9
	jmp	copy_name

copy_suffix:
	mov	cl, [r10]
	mov	[rsi], cl
	cmp	cl, 0
	je	return
	inc	rsi
	inc	r10
	jmp	copy_suffix

return:
	pop	rsi 			; Restore RAX
	ret
	
	section .data
msg_prefix:	db "One for ", 0
msg_suffix:	db ", one for me.", 0
you:		db "you", 0


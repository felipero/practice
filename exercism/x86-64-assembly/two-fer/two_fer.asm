	default	rel
	section	.text
	global	two_fer
two_fer:
	lea	r8, [msg_prefix]	; Get the address of the message prefix
	lea	r10, [msg_suffix]	; Get the address of the message suffix
	mov	r9, rdi			; Read the name arg from first argument
	cmp	r9, 0			; Check if the name is NULL
	jne	copy_prefix		; Start copying the prefix message if a name is given

set_default_name:
	lea	r9, [you]		; Get the default name address 

copy_prefix:
	mov	cl, [r8]		; Get 1 byte from the message to cl
	cmp	cl, 0			; Check if the byte in cl is NULL
	je	copy_name		; Start copying the name if cl is NULL
	mov	[rsi], cl		; Insert in *buffer
	inc	rsi			; Move rsi to the next slot
	inc	r8			; Move r8 to the next byte 
	jmp	copy_prefix		; Loop back to copy the next byte in prefix

copy_name:
	mov	cl, [r9]		; Get 1 byte from the name
	cmp 	cl, 0			; Check if the byte in cl is NULL
	je 	copy_suffix		; Start copying the suffix if cl is NULL
	mov	[rsi], cl		; Insert in *buffer
	inc	rsi			; Move rsi to the next slot
	inc	r9			; Move r9 to the next byte
	jmp	copy_name		; Loop back to copy the next byte in name

copy_suffix:
	mov	cl, [r10]		; Get 1 byte from the name
	mov	[rsi], cl		; Insert in * buffer
	cmp	cl, 0			; Check if the byte in cl is NULL
	je	return			; Jump to return if cl is NULL (end of string)
	inc	rsi			; Move rsi to the next slot
	inc	r10			; Move r10 to the next byte
	jmp	copy_suffix		; Loop back to copy the next byte in suffix

return:
	ret				; End the program
	
	section .data
msg_prefix:	db "One for ", 0
msg_suffix:	db ", one for me.", 0
you:		db "you", 0


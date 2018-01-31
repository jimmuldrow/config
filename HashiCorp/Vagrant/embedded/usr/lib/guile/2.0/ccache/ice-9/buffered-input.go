GOOF----LE-8-2.0�      ] ! 4     ha      ] g  guile�	 �	g  define-module*�	 �	 �	g  ice-9�	g  buffered-input�	 �		g  filenameS�	
f  ice-9/buffered-input.scm�	g  exportsS�	g  make-buffered-input-port�	g  make-line-buffered-input-port�	g  !set-buffered-input-continuation?!�	 �	g  set-current-module�	 �	 �	g  make-object-property�	g  buffered-input-continuation?�	g  setter�	 �	 �	f   �	g  string-length�	g  
string-ref�	g  char-whitespace?�	g  eof-object?�	g  make-soft-port�	f  r�	g  string-append�	 f  
�C 5  h`  �   ]4	
5 4 >  "  G   4i5 R      h   @  ]45 6 8      g  port
		 g  val		  g  filenamef  ice-9/buffered-input.scm�
	
��		!	�� 			  g  nameg  !set-buffered-input-continuation?!�g  documentationf  �Set the read continuation flag for @var{port} to @var{val}.

See @code{make-buffered-input-port} for the meaning and use of this
flag.� CR  hx     ]M4M5�$  :4MM5 M�N4 5$  "  445M>  "  G   C4L4M55 4 5$   C N
N"���             g  res
		J g  x
	V	q  g  filenamef  ice-9/buffered-input.scm�
	?	��		@	$��		@	��		@	��		B	��		B	��		C	)��	 	C	��	!	D	��	+	D	��	0	E	��	K	H	��	N	H	%��	V	H	��	V	H	��	Y	J	��	c	I	��	j	N	��	m	O	��	q	P	�� 		q
  g  nameg  get-character� C   h   u   ] 4M5M �C   m       g  filenamef  ice-9/buffered-input.scm�
	R	��		S	��		S	�� 		
  g  nameg  input-waiting� C  hh   5  ])
HHHO  Q K4O  5K445J>  "  G  JC   -      g  reader
		e g  read-string		e g  string-index			e g  port		
	e g  get-character			e g  port		&	/  g  filenamef  ice-9/buffered-input.scm�
	#
��		<	��		<	��	
	>	��	0	U	��	D	U	!��	F	U	R��	H	U	��	J	U	��	K	V	�� 		e  g  nameg  make-buffered-input-port�g  documentationf �Construct a line-buffered input port from the specified @var{reader}.
@var{reader} should be a procedure of one argument that somehow reads
a chunk of input and returns it as a string.

The port created by @code{make-buffered-input-port} does @emph{not}
interpolate any additional characters between the strings returned by
@var{reader}.

@var{reader} should take a boolean @var{continuation?} argument.
@var{continuation?} indicates whether @var{reader} is being called to
start a logically new read operation (in which case
@var{continuation?} is @code{#f}) or to continue a read operation for
which some input has already been read (in which case
@var{continuation?} is @code{#t}).  Some @var{reader} implementations
use the @var{continuation?} argument to determine what prompt to
display to the user.

The new/continuation distinction is largely an application-level
concept: @code{set-buffered-input-continuation?!} allows an
application to specify when a read operation is considered to be new.
But note that if there is non-whitespace data already buffered in the
port when a new read operation starts, this data will be read before
the first call to @var{reader}, and so @var{reader} will be called
with @var{continuation?} set to @code{#t}.� CR    h(   �   ]	4L  545$  C6       �       g  continuation?
		! g  str			!  g  filenamef  ice-9/buffered-input.scm�
	f	��		g	)��			g	��		h	$��		h	 ��		j	7��	!	j	$�� 		!   C      h   �  ] O 6   �      g  reader
		  g  filenamef  ice-9/buffered-input.scm�
	Y
��		f	�� 		  g  nameg  make-line-buffered-input-port�g  documentationf Construct a line-buffered input port from the specified @var{reader}.
@var{reader} should be a procedure of one argument that somehow reads
a line of input and returns it as a string @emph{without} the
terminating newline character.

The port created by @code{make-line-buffered-input-port} automatically
interpolates a newline character after each string returned by
@var{reader}.

@var{reader} should take a boolean @var{continuation?} argument.  For
the meaning and use of this argument, see
@code{make-buffered-input-port}.� CRC     {       g  m
		(  g  filenamef  ice-9/buffered-input.scm�		
��	)		%��	2	
���	
��
�	#
��Y	Y
�� 	[
   C6 
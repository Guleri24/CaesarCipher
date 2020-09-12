# CaesarCipher
 The earliest encrytion scheme is the Caesar ciper, which is named after Julius Caesar, who used
 this scheme to protect important military messages.
 
 Caesar Ciper involves replacing each letter in a message with the letter that is three letters 
 after it in the alphabet for the language. 
 So, in an English message we would replace each A with D, each B with E, each C with F, and 
 so on. We continue this approach all the way up to W, which is replaced with Z. Then, we let
 the substitution pattern wrap around, so that we replace X with A, Y with B and Z with C.
 
 Caesar Ciper as a simple formula: 
      Replace each letter i with letter (i+3)mod 26,
  where mod is modulus operator, which returns the remainder after performing an integer division.

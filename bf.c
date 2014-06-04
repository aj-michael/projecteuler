// Brainfuck interpreter
#include <stdio.h>
#include <stdlib.h>
#define ARRAYSIZE 65536
#define MAXCODESIZE 65536

int stack[MAXCODESIZE], stackp;
char code[MAXCODESIZE]; int codep, codelength;
long array[ARRAYSIZE], memp;
int targets[MAXCODESIZE];
int c;
FILE *prog;

int main(int argc, char **argv){
    codelength = fread(code, 1, MAXCODESIZE, prog);
    fclose(prog);
    for(codep=0; codep<codelength; codep++){
        if (code[codep]=='[') stack[stackp++]=codep;
        if (code[codep]==']'){
            if(stackp==0){
                fprintf(stderr,"Unmatched ']' at byte %d.", codep), exit(1);
            } else {
                --stackp;
                targets[codep]=stack[stackp];
                targets[stack[stackp]]=codep;
            }
        }
    }
    if(stackp>0){
        fprintf(stderr,"Unmatched '[' at byte %d.", stack[--stackp]), exit(1);
    }
    for(codep=0;codep<codelength;codep++){
         switch(code[codep]){
            case '+': array[memp]++; break;
            case '-': array[memp]--; break;
            case '<': memp--; break;
            case '>': memp++; break;
            case ',': if((c=getchar())!=EOF) array[memp]=c=='\n'?10:c; break;
            case '.': putchar(array[memp]==10?'\n':array[memp]); break;
            case '[': if(!array[memp]) codep=targets[codep]; break;
            case ']': if(array[memp]) codep=targets[codep]; break;
        }
    }
    exit(0);
}
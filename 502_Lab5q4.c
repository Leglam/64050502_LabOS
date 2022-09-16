#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
        pid_t pid;
        char userChoice = 'z';

        while (userChoice != 'q') {
                printf("a : ls\n");
                printf("b : ps\n");
                printf("c : who\n");
                printf("q for quit\n");
                printf("Your Decision : ");

                scanf(" %c", &userChoice);

                pid = fork();
                if (pid == 0) {
                       if (userChoice == 'a') {
                               execlp("ls", "ls", "-l", NULL);
                       //        printf("if a is error");
                       } else if (userChoice == 'b') {
                               execlp("ps", "ps", NULL);
                       //        printf("if b is error");
                       } else if (userChoice == 'c') {
                               execlp("whoami", "whoami", NULL);
                       //        printf("if c is error");
                       } else if (userChoice == 'q') {
                               printf("Thank you for using our software!\n");
                               printf("we'll send payment choice for you in the near future\n");
                       } else {
                               printf("Stop being nonsense and Input only the character that are given above!");
                       }
                               exit(0);
                }
                //      printf("Program is running!\n");
                //      printf("Please be patient.\n");
                wait (NULL);
                printf("Thank you for your waiting.\n");
        }
        printf("parent terminated\n");
        return 0;
}
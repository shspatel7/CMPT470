int main()


{
   
   char car;
printf("Which is your favaourite car:\n");
      printf("a) BMW\n");
printf("b) Audi\n");
      printf("c) Mercedes\n");
scanf("%c",&car);
   
   switch (car)
   {
      case 'a':
         printf("You like BMW\n");
break;
   case 'b':
      printf("You like Audi\n");
   break;
case 'c':
   printf("You like Mercedes\n");
break;
            default:
   printf("You entered an invalid choice\n");
}
                  return 0;



}

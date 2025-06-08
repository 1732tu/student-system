
public class GreekAlphabet {
    public static void main(String[] args) {
        int startPosition=0,endPosition=0;
        char cStart='α',cEnd='ω';
        startPosition=(int)cStart;//代码1
        endPosition=(int)cEnd;//代码2
        System.out.println("希腊字母\'α\'在unicode表中的顺序位置:"+startPosition);
        System.out.println("希腊字母表");
        for(int i=startPosition;i<=endPosition;i++){     
            char c='\0';
            c=(char)i;//代码3
            System.out.printf(" "+c);
            if((i-startPosition+1)%10==0)
            System.out.println("");
            
        }
        
    }
    
}
    /* 
public class GreekAlphabet {
    public static void main(String[] args) {
        char i='你',j='我',k='他';
        System.out.println("汉字："+i+"的位置"+(int)i);
        System.out.println("汉字："+j+"的位置"+(int)j);
        System.out.println("汉字："+k+"的位置"+(int)k);

    }
}    

   */
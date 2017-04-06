#  java解惑
## 最后的笑声
```java
public class LastLaugh {
    public static void main(String[] args) {
        System.out.println("H" + "a");
        System.out.println('H' + 'a');
    }
}
```
## 分析
①将字符类型数值的操作数提升为int数值，从char数值到int的拓宽基本类型转换时将16位的char数值零扩展到32位的int。

②当且仅当+操作符的操作数中至少有一个是String类型时，才会执行字符串连接操作。否则，执行加法。

## 解决
### 方案一 预设一个空字符窜
```
System.out.println(""+'H' + 'a');
```
### 方案二 将一个数值用String.valueOf转化为字符串
```
System.out.println(String.valueOf('H')+'a');
```
### 方案三 使用字符串缓冲区（推荐）
```
StringBuffer sb = new StringBuffer();
sb.append('H');
sb.append('a');
System.out.println(sb.toString());

```
### 方案四 JDK5.0可以使用printf方法
```
System.out.printf("%s"+'a','H');
```

## ABC
```java
public class ABC {


    public static void main(String[] args) {
        String letter = "ABC";
        char[] numbers = {'1','2','3'};
        System.out.println(letter + "essy as " + numbers.toString());
         
    }
}
```
## 建议
要将一个char数组转换成一个字符串，就要调用String.valueof(char[]）方法

## 方案一
```
System.out.println(letter + "essy as " + String.valueOf(numbers));
```
## 方案二
```
System.out.print(letters+"easy as ");  
System.out.println(numbers); 
```

## 动物庄园
```java
public class AnimalFarm {
    public static void main(String[] args) {
        String pig = "length: 10";
        String dog = "length:" + pig.length();
        System.out.println("Animalare equals:" + pig == dog);
    }
}
```
## 分析
这种用法错误，“+”的优先级比“==”高
先运算加导致最终返回false
## 建议
在使用字符串连接操作符时，总是将重要的操作数用括号括起来。在比较对象引用时，应该优先使用equals方法而不是==操作符
## 解决
### 方案一
在使用字符串连接操作符时，总是将重要的操作数用括号括起来。
```
System.out.println("Animal areequals:"+ (pig == dog));
```
### 方案二
在比较对象引用时，应该优先使用equals方法而不是==操作符
```
 System.out.println("Animal areequals:"+ pig.equals(dog));
```
## 字符串奶酪
```java
public class StringCheese {
    public static void main(String[] args) {
        byte bytes[] = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte)i;
        }
        String str = new String(bytes);
      
        for (int i = 0,n = str.length();i < n; i++) {
            System.out.println((int)str.charAt(i)+"");
        }
    }
}
```



### 分析
这里的罪魁祸首就是String(byte[])构造器。有关它的规范描述道：“在通过解码使用平台缺省字符集的指定byte数组来构造一个新的String时，该新String的长度是字符集的一个函数，因此，它可能不等于byte数组的长度。当给定的所有字节在缺省字符集中并非全部有效时，这个构造器的行为是不确定的”[Java-API]。
### 建议
每当你要将一个byte序列转换成一个String时，你都在使用某一个字符集，不管你是否显式地指定了它。如果你想让你的程序的行为是可预知的，那么就请你在每次使用字符集时都明确地指定。
### 解决
```java
public class StringCheese {
    public static void main(String[] args) {
        byte bytes[] = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte)i;
        }
        String str = null;
        try {
            str = new String(bytes,"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0,n = str.length();i < n; i++) {
            System.out.println((int)str.charAt(i)+"");
        }
    }
}
```

## 无情的增量
```java
public class Increment {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);
    }
}
```
### 分析
当++操作符被置于一个变量值之后时，其作用就是一个后缀增量操作符,表达式j++的值等于j在执行增量操作之前的初始值。因此，前面提到的赋值语句首先保存j的值，然后将j设置为其值加1，最后将j复位到它的初始值。换句话说，这个赋值操作等价于下面的语句序列：
```
int temp = j;
j = j + 1;
j = temp;

```
### 类似问题
```java
public class Demo {  
  public static void main(String[] args) {  
      int j = 0;  
      j= j++;  
      System.out.println(j);  
  }  
}
```
### 建议
不要在单个的表达式中对相同的变量赋值超过一次。


## 优柔寡断
```java
public class HelloGoodbye {
    public static void main(String[] args){
        System.out.println(decision());
        
        

    }

    private static boolean decision() {
        try{
            return true;
        }
        finally{
            return false;
        }
    }
}
```
## 分析
在一个try-finally语句中，finally语句块总是在控制权离开try语句块时执行的。无论try语句块是正常结束的，还是意外结束的，情况都是如此。
## 建议
每一个finally语句块都应该正常结束，除非抛出的是不受检查的异常。千万不要用一个return、break、continue或throw来退出一个finally语句块，并且千万不要允许将一个受检查的异常传播到一个finally语句块之外去。
## 扩展
```java
public class HelloGoodbye {  
  public static void main(String[] args){  
      try{  
          System.out.println("Hello,World!");  
          System.exit(0);  
      }finally{  
          System.out.println("Goodbye,world!");  
      }  
    }  
}
```

## 分析
不论try语句块的执行是正常地还是意外地结束，finally语句块确实都会执行。然而在这个程序中，try语句块根本就没有结束其执行过程。System.exit方法将停止当前线程和所有其他当场死亡的线程。finally子句的出现并不能给予线程继续去执行的特殊权限。System.exit将立即停止所有的程序线程，它并不会使finally语句块得到调用，但是它在停止VM之前会执行关闭挂钩操作。当VM被关闭时，请使用关闭挂钩来终止外部资源。通过调用System.halt可以在不执行关闭挂钩的情况下停止VM，但是这个方法很少使用。

# 枚举Enumeration

## 认识

实际上就是在内部创建一个**<u>常量对象</u>**，外界仅能通过给定方式访问这个对象，且不能修改。

枚举类就是可以将一系列具有统一属性、行为的有限个数对象 集中封装到一个类中。

## 自定义类

```java
class TestEnum {
    //常量对象名（引用名）全大写
    //final + static；final修饰为常量，static保证可以用类名直接调用
    public final static ENUM1 = new TestEnum();
	private String name;//属性私有
    private TestEnum(){//构造器私有
        
    };
    public void test() {//可提供向外的方法
        //可以是获取对象的方法：get对象名();//但一般不写
        //也可以是一些对象的行为方法：say();
    } 
}
```

## 关键字enum实现枚举类

~~~java
enum TestEnum {
	//开头根据构造器创建常量对象
    //若构造器是无参构造器，则直接写常量名即可
    //若构造器带参，则要填上
    //多个常量对象用逗号隔开
    ENUM1,ENUM2("name1"),ENUM3("name2");
    private String name；//属性私有
    private TestEnum(){//构造器私有
        
    }
    private TestEnum(String name){
        
    }
    public void test(){//可向外提供方法
		//可以是一些对象的行为方法：say();
    }
}
~~~

利用该关键字，实际上在底层是继承了Enum类，因此enum类不可以再继承其他类，但是可以implements其他接口。

在底层中，实现enum类其实和自定义的方法是差不多的。可以反编译查看底层实现的效果。

## 关于Enum类

~~~java
//其中的成员方法，利用enum关键字创建的类可以继承
toString();//返回该常量常量名，常用。String
ordinal();//返回该该常量在创建时的次序。int
compareTo(另一常量);//返回该常量与另一常量的次序偏移量。int

//静态方法
values();//返回一个数组，该数组按ordinal次序排序。引用类型
valueOf(String);//若字符串匹配上常量对象，则返回该对象，否则异常。引用类型
    
//关于相等的比较
可以直接用名字比较，因为这是一个常量对象，只有一份，指向的都是同一个地址
也可以用成员方法：equals()比较,Enum类重写了该方法，比较的也是地址。
~~~



# 注解Annotation

@interface，注解类

## 元注解（了解）

修饰注解的注解，即元注解

@Rentention，指定作用范围（三种）

SOURCE，在编译阶段，即在.java文件中

CLASS，在字节码阶段，即.class文件中

RUNTIME，在运行阶段，即jvm运行时会保留注解，程序可通过反射得到注解。



@Target，指定使用位置

@Documented，指定注解是否在javadoc中体现，即生成文档时，可看见该注解

@Inherited，子类继承父类注解。如果某个类使用了被@inherited修饰的注解，那么它的子类也将具有该注解



## 三种注解

@Override，使用该注解必须重写，否则报错

```java
@Target(ElementType.METHOD)//只用于方法
```

@Deprecated，使用该注解表示某元素已过时，不推荐使用，但仍可以使用。一般用于版本兼容和过渡。

```java
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})//可以用于构造器、子段、变量、方法、包、模块、参数、类型
```

@SuppressWarnings("", "", "")，使用该注解表示抑制某元素报错，可以精准抑制、也可全部抑制，

```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})//可用于类型、字段、方法、参数、构造器、变量、模块
String[] value();//可以传入多抑制信息。
```

~~~java
/*
    可以指定的警告类型有
    all，抑制所有警告
    boxing，抑制与封装/拆装作业相关的警告
    cast，抑制与强制转型作业相关的警告
    dep-ann，抑制与淘汰注释相关的警告
    deprecation，抑制与淘汰的相关警告
    fallthrough，抑制与 switch 陈述式中遗漏 break 相关的警告
    finally，抑制与未传回 finally 区块相关的警告
    hiding，抑制与隐藏变数的区域变数相关的警告
    incomplete-switch，抑制与 switch 陈述式(enum case)中遗漏项目相关的警告
    javadoc，抑制与 javadoc 相关的警告
    nls，抑制与非 nls 字串文字相关的警告
    null，抑制与空值分析相关的警告
  **rawtypes，抑制与使用 raw 类型相关的警告
    resource，抑制与使用 Closeable 类型的资源相关的警告
    restriction，抑制与使用不建议或禁止参照相关的警告
    serial，抑制与可序列化的类别遗漏 serialVersionUID 栏位相关的警告
    static-access，抑制与静态存取不正确相关的警告
    static-method，抑制与可能宣告为 static 的方法相关的警告
    super，抑制与置换方法相关但不含 super 呼叫的警告
    synthetic-access，抑制与内部类别的存取未最佳化相关的警告
    sync-override，抑制因为置换同步方法而遗漏同步化的警告
  **unchecked，抑制与未检查的作业相关的警告
    unqualified-field-access，抑制与栏位存取不合格相关的警告
  **unused，抑制与未用的程式码及停用的程式码相关的警告
*/
~~~



# 异常Exception

## 认识

程序执行中发生的不正常情况称为异常。

异常可分为两大类：Error和Exception

### Error

jvm无法解决的严重问题。如jvm系统内部崩溃、资源耗尽等。StackOverFlow、out of memory。

### Exception

因编程错误或者外界的一些因素，导致的一般性的问题，此时可以利用针对性的代码解决。

Exception又分为两类：RuntimeException和编译时异常。

#### 运行时异常

编译器检查不出来。一般是编程时出现的逻辑错误。

java.lang.RuntimeException类以及子类都是运行时异常

运行时异常可以不做处理，直接交由jvm处理。因为此类异常很普遍，若全处理会对程序的可读性和运行效率产生影响。

常见的运行时异常：

1. NullPointerException，空指针异常（引用时常见的异常）
2. ArithmeticException，数学运算异常（公式使用常见的异常）
3. ArrayIndexOutOfBoundsException，数组下标越界异常（数组使用时常见的异常）
4. ClassCastException，类型转换异常（转型时常见的异常）
5. NumberFormatException，数字格式异常（当使用包装类的parse成员方法常见的异常）
6. InputMismatchException ，输入不匹配异常（当接收Scanner类的next成员方法常见的异常）

#### 编译时异常

编译器会检查出来，程序员必须处理（try-catch-finally或者throws），否则无法编译。

常见的编译时异常：

1. SQLException，数据库操作异常
2. IOException，文件输入输出异常
3. FileNotFoundException，文件不存在异常
4. ClassNotFoundException，类不存在异常
5. EOFException，文件末尾异常
6. IllegalArguementException，非法参数异常

## 异常处理方式

### try-catch-finally

IDEA快捷键：ctrl + alt + t

执行顺序：

1. try中无异常，则执行try中全部语句，然后跳过catch执行finally的语句
2. try中有异常，则检测到异常时立即中断执行，然后进入catch里的语句，最后执行finally语句

#### try

将可能会出现的代码写进try的代码块中

#### catch

用于捕获异常

**利用异常类中的成员方法：getMessage()可以获取异常信息**。

可以存在多个catch，括号内可以是具体的异常，也可以是某一大类异常。使用即类似于if-else进行判断异常。

其中异常越精确则放置顺序越往前，异常越笼统则放置顺序越靠后（子类异常在前，父类异常在后）。

同辈异常则可以保持任意顺序。

#### finally

常用于关闭连接、释放资源



可以不写finally。

finally的代码必须执行，无论是否出现异常。



#### 关于catch与finally

catch会在退出之前执行finally的语句。

若catch代码块中，退出时要返回一个数据，则jvm会先将这个数据用临时变量保存起来，当执行完finally时再回到catch将这个临时变量内的数据返回。

#### 关于try与finally

相当于没有捕获异常，但是一定会执行finally的语句。



~~~java
    try {
        //可能出现异常的代码
    }
    catch(NullPointerException e) {
        //处理
    }
    catch(ArithmeticException e) {
        //处理
    }
    catch(Exception e) {
        //处理
    }
  /*finally{
		//代码
    }*/


public static void main(String[] args) {
		//如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
		//思路
		//1. 创建 Scanner 对象
		//2. 使用无限循环，去接收一个输入
		//3. 然后将该输入的值，转成一个 int
		//4. 如果在转换时，抛出异常，说明输入的内容不是一个可以转成 int 的内容
		//5. 如果没有抛出异常，则 break 该循环
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		String inputStr = "";
		while (true) {
			System.out.println("请输入一个整数:"); 
			inputStr = scanner.next();
			try {
				num = Integer.parseInt(inputStr); //这里是可能抛出异常NullPointerException
                //可以不用字符串接收 再解析
                //可以直接num = scanner.nextInt();//也可能会抛出异常InputMismatchException
				break;
			} catch (NumberFormatException e) {
				System.out.println("你输入的不是一个整数:");
			}
		}
		System.out.println("你输入的值是=" + num);
	}
~~~

### throws

如果某方法中可能会出现异常，且不确定如何处理该异常，则此方法应显式地（声明）抛出该异常，表示该方法不对这些异常处理，而由方法的调用者（上一级方法）来处理异常。

抛出的可以是精确的异常，也可以是异常的父类。

可以抛出多个异常，用逗号分隔。

运行异常可以不用处理，则默认throws，但编译异常必须显式地处理，不会默认 throws。

子类重写父类的方法时，对抛出的异常具有规定：子类重写的方法，所抛出的异常类型 要么和父类抛出的异常一致；要么为父类抛出的异常的类型的子类型。



## 自定义异常

当自定义异常类继承RuntimeException时，为运行时异常；继承Exception时，为编译时异常。

一般情况下，我们自定义异常是继承 RuntimeException，即把自定义异常做成 运行时异常，好处是，我们可以使用默认的处理机制，即比较方便。

~~~java
//创建语法
class AgeException extends RuntimeException {
	public AgeException(String message) {//构造器
		super(message);
	}
}

//具体使用（抛出自定义异常）：throw new AgeException("年龄需要在 18~120 之间");//创建的对象也可以是已有的异常类，然后再重新写入自己想要夫人异常信息
~~~



## throws与throw

| 关键字 | 意义                     | 位置       | 后面跟着的东西 |
| ------ | ------------------------ | ---------- | -------------- |
| throws | 处理异常的方式           | 方法声明中 | 异常类型       |
| throw  | 手动生成异常对象的关键字 | 方法体中   | 异常对象       |





# 包装类Wrapper

| 八种包装类型 | 对应的基本数据类型 |
| ------------ | ------------------ |
| Boolean      | boolean            |
| Character    | char               |
| Integer      | int                |
| Byte         | byte               |
| Short        | short              |
| Long         | long               |
| Float        | float              |
| Double       | double             |

## 继承关系

除了Boolean和Character，其他的包装类都继承了Number类，同时所有包装类还继承了Comparable接口和Object类

## 包装类与基本数据类型转换

装箱：基本类型--->包装类型

拆箱：包装类型-->基本类型



jdk5以前，只能手动装箱和手动拆箱

装箱方式：`Integer integer = new Integer(n1);`或者`Integer integer = Integer.valueOf(n1);`

拆箱方式：`int n2 = integer.intValue();`



jdk5以后可以自动装箱和自动拆箱

装箱方式：`Integer integer = n1;`

拆箱方式：`int n2 = integer;`

### 底层

装箱：Integer integer = n1; ------>Integer.valueOf(n1);---->new Integer(n1) 或者 是已经创建好的对象（具体看源码）;

拆箱：int n2 = integer;------------->integer.intValue();



包装类与String类转换

```java
//包装类---->String
Integer integer = 10;
//方式1
String str1 = integer + "";
//方式2
String str2 = Integer.toString();
//方式3
String str3 = String.valueOf(integer);


//String----->包装类
String str = "123";
//方式1
Integer integer1 = Interger.parseInt(str);//Interger.parseInt(str)返回的是一个int类型，所以此处还用了自动装箱
//方式2
Integer integer2 = new Integer(str);//构造器
```

## 关于值、地址比较

例子可看这篇[博客](https://blog.csdn.net/tataoto/article/details/123610355?ops_request_misc=&request_id=&biz_id=102&utm_term=%E5%8C%85%E8%A3%85%E7%B1%BB%E5%92%8C%E5%9F%BA%E6%9C%AC%E7%B1%BB%E5%9E%8B%E6%AF%94%E8%BE%83%E5%80%BC&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-123610355.142^v71^js_top,201^v4^add_ask&spm=1018.2226.3001.4187)。可搭配源码、断点来了解。

值比较重点是自动拆箱和重写equals方法。

地址比较重点是cache数组。



## 包装类的其他方法

有需要时查源码



# String类
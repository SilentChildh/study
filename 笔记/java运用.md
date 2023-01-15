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
String str2 = integer.toString();
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





## Integer常用成员

| 成员                                | 作用                   |
| ----------------------------------- | ---------------------- |
| Integer.MAX_VALUE                   | 返回最大值             |
| Integer.MIN_VALUE                   | 返回最小值             |
|                                     |                        |
| integer.toString()//普通方法        | 对象值转为字符串       |
| Interger.parseInt(String)//静态方法 | 字符串转为对象值       |
|                                     |                        |
| Integer.valueOf(int)//静态方法      | 装箱。基本值转为对象值 |
| integer.intValue()//普通方法        | 拆箱。对象值转为基础值 |
|                                     |                        |

## Character常用成员

| 成员                               | 作用     |
| ---------------------------------- | -------- |
| Character.isDigit('a')//静态       | 判断数字 |
| Character.isLetter('a')//静态      | 判断字母 |
| Character.isUpperCase('a')//静态   | 判断大写 |
| Character.isLowerCase('a')//静态   | 判断小写 |
|                                    |          |
| Character.isWhiteSpace)('a')//静态 | 判断空格 |
| Character.toUpperCase('a')//静态   | 转成大写 |
| Character.toLowerCase('a')//静态   | 转成小写 |
|                                    |          |



## 包装类的其他方法

有需要时查源码



# String类

## 创建String对象

### 直接赋值

String  str = "string";

1. 先检查常量池中是否存在"string"这个数据，如果有，那么str指向该地址。
2. 如果没有，那么在常量池中创建string这个数据，然后str再指向该地址。



### 利用构造器

String str = new String("string");

1. 在堆区创建一个空间，str指向堆区的这个地址。
2. 堆区中其实是保存了一个value属性，该属性指向常量池的地址。
3. 检查常量池是否存在string这个数据，
    1. 如果有，那么value直接指向该地址；
    2. 如果没有，那么在常量池中创建string这个数据，str再指向该地址。



## 特性

final类，不可再继承。

value数组被final修饰，所以由String 创建的字符序列内容不可变动，将一直保留在常量池中。

每次修改实际上是修改value指向的地址。

字符统一用unicode编码，一个字符两字节



创建时注意的事项

指向常量池的引用相加

```java
//假设常量池中没有数据
String str1 = "string1";//此时创建一个string1这个数据
str1 = "string";//此时又创建了一个string2这个数据。
//string1和string2都存放于常量池中，str1的变化是：一开始指向string1的地址，后来指向string2的地址
```

~~~java
//假设常量池中没有数据
String str2 = "string1" + "string2";//此时只创建了一个string1string2这个数据。
//即等价于 String str2 = "string1string2";
//因为会做优化，先组合起来，判断常量池中是否存在这个数据，没有就创建，然后str2指向该地址。
~~~

只要出现一个在堆中以value来指向常量池的引用相加

~~~java
String str1 = "string1";
String str2 = "string2";
String str3 = str1 + "string2";
/*
	底层原理：
	1. StringBuilder str = new StringBuilder();//先创建一个StringBuilder对象
	2. str.append(str1);
	3. str.append("string2");
	4. 最后执行str.toString()返回一个存储在堆区的字符串对象，
		赋值给str3
	*/
~~~

## 常用方法

| 成员                                                     | 作用                                                         |
| -------------------------------------------------------- | ------------------------------------------------------------ |
| string.equals(String)//普通                              | 判断相等，区分大小写                                         |
| string.equalsIgnoreCase(String)//普通                    | 判断相等，忽略大小写                                         |
| string.length)()//普通                                   | 返回字符串长度                                               |
| string.indexOf(String/**int（传入一个字符实参）**)//普通 | 找第一次出现的索引值，不存在返回-1                           |
| string.lastIndexOf(String/int(传入一个字符实参))//普通   | 从右往左找                                                   |
| string.substring(索引值)//普通                           | 获取索引值以后的子串                                         |
| string.substring(前索引值, 后索引值)//普通               | 获取左闭右开的子串                                           |
| string.charAt(int)//普通                                 | 获取索引位置字符                                             |
|                                                          |                                                              |
| string.toUpperCase()//普通                               | 转换成大写                                                   |
| string.toLowerCase()//普通                               | 转换成小写                                                   |
| string.concat(String)//普通                              | 拼接字符串                                                   |
| string.replace(目标String, 指定String)//普通             | 将目标字符串替换为指定字符串                                 |
| string.split(指定String)//普通                           | 以字符串中的指定字符串为分隔界限，返回String数组             |
| string.compareTo(String)//普通                           | 比较字符串大小。1. 字符串长度相同时，返回字符大小差值。2.长度不同时，返回长度差值。 |
| string.toCharArray()//普通                               | 返回char数组                                                 |
| String.format()//静态                                    | 和printf差不多，返回String字符串                             |
|                                                          |                                                              |
| string.intern()//普通                                    | 返回常量池中字符串的地址                                     |



# StringBuffer类

## 特性

是一个final类，不可被继承

value数组不被final修饰，是可变的字符序列，可对字符串中的内容修改。

用value数组指向存放字符数组地址，该字符数组是在堆区的，而不是在常量区。所以可以不断在原来的数组上修改内容（空间不足再扩容），而不像String中每次修改实际上是变换指向的地址。

## 构造器

默认构造的value数组大小是16字节

1. StringBuffer();
2. StringBuffer(int Capacity);//指定数组大小
3. StringBuffer(String str)//指定一个字符串，大小 = str.length() + 16



## String与StringBuffer转换

String------>StringBuffer

~~~java
//方式1
StringBuffer str1 = new StringBuffer(String s);//构造器
//方式2
StringBuffer str2 = str1.append(String s);//StringBuffer的append(String str)方法

~~~

StringBuffer--------->String

~~~java
//方式1
String str1 = new String(StringBuffer s);//构造器
//方式2
StringBuffer str = ...;
String str2 = str.topString();//利用StringBuffer的toString()方法
~~~

## 常见方法

| 成员                                                      | 作用                     |
| --------------------------------------------------------- | ------------------------ |
| stringBuffer.append(String s);//普通                      | 拼接/追加字符串          |
| stringBuffer.delete(int start, int end);//普通            | 左闭右开山删除           |
| stringBuffer.replace(int start, int end, String s);//普通 | 左闭右开替换为指定字符串 |
| stringBuffer.indexOf(String s);//普通                     | 返回索引值，没有就返回-1 |
| stringBuffer.lastIndexOf(String s)//普通                  | 从右往左                 |
| stringBuffer.insert(String s)//普通                       | 索引值位置插入字符串     |
|                                                           |                          |
|                                                           |                          |
|                                                           |                          |

# StringBuilder类

## 特性

几乎和StringBuffer一样。StringBuilder被设计为StringBuffer的简易替换。当单线程时好用。

但是不是线程安全的。

## 常用方法

与StringBuffer一致。

主要的方法是使用append和insert





# 三种String比较

1. StringBuilder与StringBuffer十分类似，均是可变序列，且方法差不多
2. String是不可变序列。



## 使用

1. 字符串序列较少修改，被多个对象引用，使用String

2. 字符串大量修改

    1. 且单线程，使用StringBuilder
    2. 且多线程，使用StringBuffer

    





# Math类

Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。



| 常用成员（都是静态）                          | 作用                                      |
| --------------------------------------------- | ----------------------------------------- |
| Math.abs(int/long/float/double)               | 对应类型绝对值                            |
| Math.pow(double, double)                      | double类型乘方                            |
| Math.ceil(double)                             | double类型向上取整                        |
| Math.floor(double)                            | double类型向下取整                        |
| Math.floor(参数+0.5)                          | 四舍五入                                  |
| Math.round(float/double)                      | int/longd类型，四舍五入                   |
| Math.sqrt(double)                             | double类型，开方                          |
| Math.random()                                 | double类型，0 <= x < 1 之间的一个随机小数 |
| Math.log10(double)                            | double类型，返回对应log值                 |
| Math.min(int, int)//也可对比long/float/double | 返回最小值                                |
| Math.max(int, int)//也可对比long/float/double | 返回最大值                                |
|                                               |                                           |
|                                               |                                           |
|                                               |                                           |
|                                               |                                           |



# Arrays类

管理数组的方法

| 常用方法（静态）                 | 作用                                                     |
| -------------------------------- | -------------------------------------------------------- |
| Arrays.toString(arr)             | 返回数组的字符串形式，具体看源码                         |
| Arrays.sort(arr)                 | 升序排序                                                 |
| Arrays.sort(arr, compare)        | 自定义排序                                               |
| Arrays.binarySearch(arr,  value) | 返回目标的索引值，没找到返回（-(expected position + 1)） |
| Arrays.copyOf(arr, length)       | 返回数组                                                 |
| Arrays.fill(arr, value)          | 进行填充覆盖操作                                         |
| Arrays.equals(arr1, arr2)        | 返回boolean值，判断是否内容相同                          |
| Arrays.asList(可变参数)          | 返回List                                                 |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |
|                                  |                                                          |



# System类

| 常用方法                                       | 作用                                                         |
| ---------------------------------------------- | ------------------------------------------------------------ |
| exit(0)                                        | 正常结束程序                                                 |
| System.arraycopy(src, pos, dsrc, dpos, length) | 将src从pos的位置开始的length个值复制给dsrc从dpos位置开始的位置 |
| System.currentTimeMillis()                     | 返回从1970.1.1 00:00:00到现在的毫秒时间（long）              |
| System.gc()                                    | 垃圾回收机制                                                 |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |
|                                                |                                                              |



# Big类

- BigInteger类用于保存大整型数据
- BigDecimal类用于保存高精度数据

两个类都存在乘除加减的成员方法

| 常用成员                                                | 作用                        |
| ------------------------------------------------------- | --------------------------- |
| BigInteger/BigDecimal(String s)//构造器                 | 创建对象                    |
| bigInteger/bigDecimal.add(Big类)                        | 加                          |
| bigInteger/bigDecimal.subtract(Big类)                   | 减                          |
| bigInteger/bigDecimal.multiply(Big类)                   | 乘                          |
|                                                         |                             |
| bigInteger.divide(BigInteger)                           | 大整数除                    |
| bigDecimal.divide(BigDecimal)                           | 高精度除,无限循环时抛出异常 |
| bigDecimal.divide(BigDecimal, BigDecimal.ROUND_CEILING) | 高精度除，以分子精度为准    |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |
|                                                         |                             |

# 日期类

## 第一代

![](https://img-blog.csdnimg.cn/0e08fa504c7f40a8aa907edfe43256ae.png)

~~~java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Date01 {
    public static void main(String[] args) throws ParseException {
        //老韩解读
        //1. 获取当前系统时间
        //2. 这里的Date 类是在java.util包
        //3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
        Date d1 = new Date(); //获取当前系统时间
        System.out.println("当前日期=" + d1);
        Date d2 = new Date(9234567); //通过指定毫秒数得到时间
        System.out.println("d2=" + d2); //获取某个时间对应的毫秒数

        //老韩解读
        //1. 创建 SimpleDateFormat对象，可以指定相应的格式
        //2. 这里的格式使用的字母是规定好，不能乱写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1); // format:将日期转换成指定格式的字符串
        System.out.println("当前日期=" + format);

        //老韩解读
        //1. 可以把一个格式化的String 转成对应的 Date
        //2. 得到Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        //3. 在把String -> Date ， 使用的 sdf 格式需要和你给的String的格式一样，否则会抛出转换异常
        String s = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse=" + sdf.format(parse));
    }
}
~~~

|                                                       |                                                      |
| ----------------------------------------------------- | ---------------------------------------------------- |
| Date()//构造器                                        | 获取当前系统时间                                     |
| Date(9234567)//构造器                                 | 通过指定毫秒数得到时间                               |
|                                                       |                                                      |
| SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E")//构造器 | 创建指定格式d的对象                                  |
| simpleDateFormat.format(Date)                         | 将Date转换成指定格式的String                         |
| simpleDateFormat.parse(s)                             | 格式化的String （即符合格式的String）转成对应的 Date |
|                                                       |                                                      |
|                                                       |                                                      |
|                                                       |                                                      |
|                                                       |                                                      |
|                                                       |                                                      |



## 第二代

~~~java
import java.util.Calendar;
public class Calendar_ {
    public static void main(String[] args) {
        //老韩解读
        //1. Calendar是一个抽象类， 并且构造器是private
        //2. 可以通过 getInstance() 来获取实例
        //3. 提供大量的方法和字段提供给程序员
        //4. Calendar没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        //5. 如果我们需要按照 24小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        //2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        // 这里为什么要 + 1, 因为Calendar 返回月时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );
    }
}
~~~

|                                     |                |
| ----------------------------------- | -------------- |
| Calendar.getInstance()              | 创建日历类对象 |
|                                     |                |
| calendar.get(Calendar.YEAR)         | 年             |
| calendar.get(Calendar.MONTH) + 1)   | 月             |
| calendar.get(Calendar.DAY_OF_MONTH) | 日             |
|                                     |                |
| calendar.get(Calendar.HOUR)         | 12小时制       |
| calendar.get(Calendar.HOUR_OF_DAY)  | 24小时制       |
| calendar.get(Calendar.MINUTE)       | 分             |
| calendar.get(Calendar.SECOND)       | 秒             |
|                                     |                |
|                                     |                |
|                                     |                |
|                                     |                |



## 第三代

![](https://img-blog.csdnimg.cn/ff36463c50f94200a80d1e7e4b436950.png)

~~~java
package com.hspedu.date_;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期
        //老韩解读
        //1. 使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);
        
        //2. 使用DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);
        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒

        //提供 plus 和 minus方法可以对当前时间进行加或者减
        //看看890天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890天后=" + dateTimeFormatter.format(localDateTime));

        //看看在 3456分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456分钟前 日期=" + dateTimeFormatter.format(localDateTime2));
    }
}
~~~

|                                                    |                                       |
| -------------------------------------------------- | ------------------------------------- |
| LocalDateTime.now()                                | 返回对象                              |
| LocalDate.now()                                    | 返回对象                              |
| LocalTime.now()                                    | 返回对象                              |
|                                                    |                                       |
| DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") | 返回指定格式DateTimeFormatter对象     |
|                                                    |                                       |
| dateTimeFormatter.format(LocalDateTime ldt)        | 将LocalDateTime转换成指定格式的String |
|                                                    |                                       |
| local类引用.getYear()                              | 年                                    |
| local类引用.getMonth()                             | 月(letter)                            |
| local类引用.getMonthValue()                        | 月(digit)                             |
| local类引用.getDayOfMonth()                        | 日                                    |
|                                                    |                                       |
| local类引用.getHour()                              | 时                                    |
| local类引用.getMinute()                            | 分                                    |
| local类引用.getSecond()                            | 秒                                    |
|                                                    |                                       |
| local类引用.plusDays(long)                         | 添加日/周/月/年/时/分/秒              |
| local类引用.minusDays(long)                        | 减少日/周/月/年/时/分/秒              |
|                                                    |                                       |
|                                                    |                                       |
|                                                    |                                       |
|                                                    |                                       |


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
| string.compareTo(String)//普通                           | 比较字符串大小。（按字典序排序）1. 字符串长度相同时，返回字符大小差值。2.长度不同时，返回长度差值。 |
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

## 时间戳与Date

![](https://img-blog.csdnimg.cn/9184ec46cceb41188fed980c46c5009c.png)

|                          |                         |
| ------------------------ | ----------------------- |
| Instant.now()//静态      | 创建对象                |
|                          |                         |
| Date.from(Instant)//静态 | 返回对象Instant--->Date |
| date.toInstant()//普通   | 返回对象Date--->Instant |



# 集合

## 好处

- 动态保存任意多个对象
- 提供一系列操作对象的方法
- 简洁明了

## Collection接口

## 特点

- 其下的实现子类可以存放多个Object对象
- 有些可存放重复元素，有些不可以
- Collection没有直接的实现子类，都是通过子接口Link和Set实现的

## 常用方法

| 方法(普通)             | 作用                    |
| ---------------------- | ----------------------- |
| 引用.add()             | 添加元素                |
| 引用.remove(Object)    | 删除元素boolean         |
| 引用.contains(Object)  | 判断元素是否存在boolean |
| 引用.size()            | 返回大小int             |
| 引用.isEmpty()         | 判断是否为空boolean     |
| 引用.clear()           | 清空void                |
| 引用.addAll(集合)      | 添加元素                |
| 引用.containsAll(集合) | 判断多个元素存在        |
| 引用.removeAll(集合)   | 删除多个元素boolean     |
|                        |                         |
|                        |                         |
|                        |                         |
|                        |                         |
|                        |                         |



## 遍历方式

### 迭代器

认识：

- 在Iterable接口中。
- Iterator不存放元素，只用于遍历。

常用方法：

~~~java
Iterator it = 集合引用.iterator();//获取对应迭代器，一开始指向-1的索引位置
it.hasNext();//返回boolean，判断是否还有下一个元素
Oject obj = it.next();//迭代器向下移动，并返回下一个元素的对象
~~~

### 遍历方式1

idea快捷键：itit

~~~java
while(it.hasNext()) {
    Object obj = it.next();
    //.......
}
~~~

### 遍历方式2

增强for，底层也是迭代器的运用

idea快捷键：大写i，

~~~java
for(Object obj : 引用) {
	//.....
}
~~~

### 遍历方式3

~~~java
for(int i = 0; i < 引用.size(); i++) {
	//...
}
~~~

# List接口

## 认识

1. List集合中，元素可重复
2. 每个元素具有索引值，可用get(索引)访问。
3. 常用的实现类有：Vector、ArrayList、LinkedList

## 常用方法

| 方法                                | 作用                                                         |
| ----------------------------------- | ------------------------------------------------------------ |
| add(int index, Object ele)          | 在索引位置添加元素boolean                                    |
| addAll(int index, Collection eles)  | 在索引位置添加元素boolean                                    |
| get(Object obj)                     | 获取索引位置的对象                                           |
| indexOf(Object obj)                 | 第一次查找到对象的索引值                                     |
| lastIndexOf(Object obj)             | 从右往左                                                     |
| remove(int index)                   | 删除索引位置的元素，并返回对象                               |
| set(int index, Object obj)          | 替换索引位置的元素                                           |
| subList(int fromIndex, int toIndex) | 获取左闭右开的子集合（对它返回的子集合操作或对原集合操作，两个集合会互相影响，还容易出异常） |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |
|                                     |                                                              |



## 三种List实现类

1. 可以加入所有元素，包括null
2. ArrayList是由数组实现的
3. ArrayList与Vector几乎相同，但ArrayList线程不安全，效率高；Vector用于多线程。

## ArrayList

1. 其中维护了一个 `transient Object[] elementData`数组，transient修饰代表该属性不会被序列化
2. 构造器：无参时容量为0，第一次添加时，扩容为10；有参时，可指定容量大小。当容量不足时，扩容为原容量的1.5倍。
3. 不安全，效率高

## Vector

1. 其中维护了一个`protected Objectp[] elementData`数组。
2. 构造器，无参时容量为10；有参时，可指定容量大小。容量不足时，扩容为原容量的2倍。
3. 安全，效率低



## LinkedList

1. 实现了双向链表和双向队列
2. 线程不安全





# Set接口

## 认识

1. 无索引
2. 能存放任何元素，但无重复元素
3. 常用实现类：HashSet、TreeSet

## 常用方法

除去索引操作不提供get、set方法，其他与Link差不多

## HashSet

### 底层

首先，HashSet实际上是调用HashMap

数据结构 = 数组 + 链表 + 红黑树

添加操作add(Object obj)的底层机制：

1. 在添加元素时，
    1. 得到对象哈希值
    2. 解决碰撞
    3. 转换为索引值
2. 判断table表在索引位置是否存在元素
    1. 没有，则直接添加
    2. 有，则调用equals()比较.（equals可重写，即自由决定比较标准）
        1. 相同，则放弃添加
        2. 不相同，则在该结构上继续按equals()对比，直到最后一个都不相同则添加

数据结构的机制：表头即table数组，每个数组的元素都可以存放HashMap.Node结点类。一开始，每个结点后面由链表连接，后面由红黑树连接。

每添加一个元素后，该HashMap对象中的大小size就自增。当size到达临界值threshold时，就开始令table数组扩容，并且临界值也随之变化。当链表结点超过8个，且size超过64时，结构由链表变为红黑树。

第一次进行添加操作时，size大小为0，table数组默认扩容为16，loadFactor加载因子是0.75，threshold默认是12（loadFactor * 16）。数组扩容是原容量的2倍。

当到达临界值12时，便会扩容为16 * 2 = 32，threshold变为（0.75 * 32） = 24。扩容以此类推。

## LinkedHashSet

HashSet的子类，底层调用LinkedHashMap

数据结构 = 数组 + 双向链表

底层机制和HashSet差不多。可以存放LinkedHashMapEntry类结点，该类继承HashMap.Node类。



# Map接口

## 认识

1. Map 中的 key 和  value 可以是任何引用类型的数据，会封装到HashMap$Node 对象中
2. Map 中的 key 不允许重复，原因和HashSet 一样。当有相同的key时 , 就等价于替换.
3. Map 中的 value 可以重复
4. Map 的key 可以为 null, value 也可以为null ，注意 key 为null,只能有一个，value 为null ,可以多个
5. 常用String类作为Map的 key
6. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
7. 最常用：HashMap、Hashable、Properties

## 储存键值对

一对k-v放在HashMap.Node里；HashMap.Node implements Map.Entry；

在Map中，将键值对HashMap.Node放在Map.Entry接口里，Map.Entry接口又放在HashMap.EntrySet集合里。之所以要这样处理，是因为在Map.Entry接口方便遍历。K getKey(); V getValue();

并且key值还保存在了HashMap.KeySet类中；value值还存在HashMap.Values类中.其实在这两类中，都是指向HashMap.Node

~~~java
Map map = new HashMap();
map.put("no1", "韩顺平");//k-v
map.put("no2", "张无忌");//k-v
map.put(new Car(), new Person());//k-v
//System.out.println(map.getClass()); //HashMap


Set set = map.entrySet();
System.out.println(set.getClass());// HashMap$EntrySet
for (Object obj : set) {
    //System.out.println(obj.getClass()); //HashMap$Node
    //为了从 HashMap$Node 取出k-v
    //先做一个向下转型Object ----> Map.Entry, 而不是HashMap.Node ---> Map.Entry
    Map.Entry entry = (Map.Entry) obj;
    //System.out.println(entry.getClass()); //HashMap$Node
    System.out.println(entry.getKey() + "-" + entry.getValue() );
}


Set set1 = map.keySet();
System.out.println(set1.getClass());//class java.util.HashMap$KeySet
Collection values = map.values();
System.out.println(values.getClass());//class java.util.HashMap$Values
~~~

## Map接口常用方法

| 方法（普通）   |                  |
| -------------- | ---------------- |
| put(K, V)      | 添加键值对       |
| remove(K)      | 删除键值对       |
| get(K)         | 返回value        |
| size()         | 返回大小         |
| isEmpty()      | 判断为空         |
| clear()        | 清空             |
| containsKey(K) | 查找Key，boolean |
|                |                  |
|                |                  |

## Map接口遍历方式



| 涉及方法                 | 作用                               |
| ------------------------ | ---------------------------------- |
| map.keySet()             | 返回key的Set集合                   |
| map.values()             | 返回value的Collection集合          |
| map.entrySet()           | 返回含有键值对的Set集合            |
|                          |                                    |
| 引用集合.iterator()      | 返回对应集合的迭代器               |
| iterator.hasNext()       | 判断是否有下一个元素               |
| iterator.next()          | 迭代器移动到下一个元素，并返回元素 |
|                          |                                    |
| map.get(K)               | 返回对应key的value                 |
| 默认toString()           | 打印信息                           |
|                          |                                    |
| Map.Entry引用.getKey()   | 返回key                            |
| Map.Entry引用.getValue() | 返回value                          |

~~~java
//利用map.keySet()获得key集合，进行遍历。
//方法主要是迭代器方法和Map接口的get(K)
        Set keyset = map.keySet();
        //System.out.println(keyset.getClass());//HashMap$KeySet
        System.out.println("-----第一种方式-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println("----第二种方式--------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

//利用map.values()获得value集合，进行遍历
//方法主要是迭代器方法
        Collection values = map.values();
        //System.out.println(keyset.getClass());//HashMap$Values
        System.out.println("---第一种方式----");
        for (Object value : values) {
            System.out.println(value);
        }
        System.out.println("---第二种方式----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);
        }

//利用map.EntrySet()获得Set集合，进行遍历
//方法主要是Map.Entry接口的getKey和getValue方法，再加上迭代器
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
        System.out.println("----第一种方式----");
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        System.out.println("----第二种方式----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry =  iterator3.next();
            //System.out.println(next.getClass());//HashMap$Node -实现-> Map.Entry (getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}
~~~

HashMap.Node是访问权限的原因，不可以向下转型为Node，因此只能转为Map.Entry.

Map.Entry其实就只是一个接口，一个工具，一个中转站，用于衔接Node、Object以及k-v内的对象，



## HashMap

1. 从线程不安全
2. 使用频率最高的Map接口类
3. 使用方法与上述一致
4. 效率比Hashtable高

## Hashtable

1. 键值不许为null
2. 使用方法与上述一致
3. 线程安全
4. 效率比HashMap低

### 底层

底层存在Hashtable$Entry[] table数组，初始化大小为11，扩容机制为 原数组容量 * 2 + 1

临界值threshold初始值为8，每次扩容更新为loadfactor * 数组容量大小

加载因子loadfactor为0.75

## Properties

1. 继承Hashtable
2. 用法与Hashtable类似
3. 可用于xxx.properties文件（配置文件）中，将文件数据加载到Properties对象中进行操作。

注意一个方法：`properties.getProperty(Key)`，如果value值得类型不是Stirng，则返回null



# 集合的选择

![](https://img-blog.csdnimg.cn/839b8e61efc344cbb581d9a043d8f839.png)



# TreeSet与TreeMap

## TreeSet

1. 使用TreeSet 提供的一个构造器，可以传入一个比较器(匿名内部类)指定排序规则
    1. 构造器把传入的比较器对象，赋给了 TreeSet的底层的 TreeMap的属性this.comparator
    2. 如果比较器相等，即返回0。那么这个Key就没有加入，即不会替换key的值





# Collections工具



| 常用方法（静态）                                    | 作用                          |
| --------------------------------------------------- | ----------------------------- |
| sort(List)//可加比较器                              | 排序                          |
| reverse(List)                                       | 翻转                          |
| shuffle(List)                                       | 随机排序                      |
| swap(List, int ,int)                                | 交换                          |
| max(Collection)//可加比较器                         | 集合中最大值                  |
| min(Collection)//可加比较器                         | 集合中最小值                  |
| frequency(Collection, Object)                       | 集合中对象出现次数            |
| copy(List dest, List src)                           | 复制，要保证dest容量>=src容量 |
| replaceAll(List list, Object oldVal, Object newVal) | 替换List集合中的值            |
|                                                     |                               |
|                                                     |                               |
|                                                     |                               |
|                                                     |                               |
|                                                     |                               |





# 泛型

## 认识

1.  编译时检查了元素的类型，提高了安全性
2. 泛型又称参数化类型
3. 类声明、成员声明时，只需要泛化类型。实例化时指定具体的类型。
4. 使代码简洁、健壮，在编译时无异常，那么运行时就不会出现ClassCastEception

## 作用

通过标识符，表示属性、方法的返回值、参数的类型

## 语法

`interface 接口 <E, R> {}` 或`class 类名 <E, R> {}`

## 使用

1. <>内可以使任大写字母

2. <>内传入的一定是引用类型

3. 具体实例化时，一般用左边指定泛型类型，而右边会默认以左边的为准。

    即`List<String> list = new ArrayList<>();`

4. 传入的成员可以是泛型类型的子类，从本质来看其实就是多态的使用。如构造器：

    ~~~java
    //A是B的父类
    Pig<A> aPig = new Pig<A>(new A());
    Pig<A> aPig2 = new Pig<A>(new B());
    ~~~

5. 对于声明了使用泛型的类或接口，当实例化时，若不指定泛型类型，那么默认Object。

    如：`List list = new ArrayList();`，此时默认泛型类型是Object

## 自定义泛型

1. 普通成员可以用泛型，静态成员不可以
2. 使用泛型的数组，不可以在声明时指定大小



- 使用自定义泛型时，继承接口或者实现接口时，都要确定泛型类型。否则默认是Object，且会警告：Raw use of parameterized class

    

## 泛型方法

用在普通方法中，如：`public <E, R> void methon (E e, R r) {}`

## 泛型的继承

1. <?>: 支持任意泛型类型
2. <? extends A>:向下兼容
3. <? super A>:向上兼容





# IO操作

## 简单的文件操作

### 创建文件对象

~~~java
new File(String pathname);//根据路径
new File(File parent, String child);//根据父目录文件 + 子路径
new FIle(String parent, String child);//根据父目录 + 子路径
~~~

### 创建新文件

创建时，需抛出异常

~~~java
file.createNewFile();//根据文件对象创建新文件
~~~

### 获取文件信息

~~~java
file.getName();//获取文件名称
file.getAbsolutePath();//获取文件的绝对路径
file.getParent();//获取文件的父级目录
file.length();//获取文件的字节大小
file.exists();//文件是否存在
file.isFile();//是否是文件
file.isDirectory();//是否是目录
~~~



### 创建目录和文件删除

~~~java
mkdir();//创建一级目录
mkdirs();//创建多级目录
delete();//删除 空目录 或 文件
~~~

## IO流

## 分类

按数据单位：字节流的二进制文件和字符流的文本文件

按数据流的流向：输入流和输出流

流的角色：节点流和处理流/包装流

![](https://img-blog.csdnimg.cn/01399f5e466147a69952416b3e7cf020.png)

### InputStream

是所有字节输入流的超类

其下的常用子类为：文件输入流`FileInputStream`、缓冲字节输入流`BufferedInputStream`(`FiltereInputStream`的子类)、对象字节流`ObjectInputStream`



## 节点流与处理流

节点流：可以从特定的数据源读写数据

处理流：也称包装流。是连接在已存在的流之上的流，为程序提供更强大的读写功能。

![](https://img-blog.csdnimg.cn/9a6c1b8cc592494c8f02ba47ac0d9041.png)

## 节点流

### FileInputStream

~~~java
new FileInputStream(String/File);//创建对象

int readData = 0;
while((readData = fileInputStream.read()) != -1) {//循环读取，直到文件末尾，然后返回-1
    //读取的数据在readData中
}
//利用read(byte[] b)，提高读取效率
int readLen = 0;
byte[] buf = new buf[8];//指定一次读取的字符数量
while((readLen = fileInputStream.read(buf) != -1) {//返回读取到的字符数量
    //读取的数据在buf数组中
    //System.out.print(new String(buf, 0, readLen));//打印读入数据
    
}

fileInputStream.close();//关闭文件资源

~~~



### FileOututStrream

~~~java
new FileOutputStream(Strint/File, boolean);//创建对象，以及是否追加（true），覆盖（false）

fileOutputStream,write(int);//写入一个字符
fileOutputStream.write(byte[] b, int, int);//写入字符串，指定写入起始偏移量和长度
//可通过String中的getByte()成员方法将字符串转换为byte数组。
fileOutoutStram.write(byte[] b/string.getByte());//写入字符串

close();
~~~

### FileIn与FileOut的搭配

~~~java
package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stream {
    public static void main(String[] args) {
        String srcPath = "e:/Git";
        String destPath = "e:/Git/Github";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] buf = new byte[1024];
            int readLen = 0;
            while((readLen = fileInputStream.read(buf)) != -1) {
                //在循环写入时，一定是三个参数
                //因为循环读取时，byte数组并不是清空再接收，而是数据覆盖
                //所以在最后可能会出现数据量小于数组容量的情况，那么实际上接收的是数组的前半段，而后半段是上一轮接收过的数据
                fileOutputStream.write(buf, 0, readLen);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(fileInputStream != null) fileInputStream.close();
                if(fileOutputStream != null) fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
~~~

### FileReader

~~~java
new FileReader(String/File);//创建对象

read();//读取字符
read(char[]);//读取字符串，返回字符长度
//相关API
new String(char[]);
new String(char[], int ,int);//指定起始偏移量和长度

//循环读取的模板与InputStream一致
//单个字符则用int readData接收
//字符串则用 char[] buf数组接收。System.out.print(new String(buf, 0, readLen));

close();
~~~

### FileWriter

~~~java
new FileWriter(String/File, boolean);//创建对象，是否追加

write(int);//写入单个字符
write(char[]);
write(char[], int, int);
write(String);
write(String, int ,int);
//相关API
string.toCharArray();//字符串转换为字符数组

close();
~~~





## 处理流

### 特点

处理流连接在已存在的流之上的流。

处理流可以消除不同流之间的差异，同时也提供了更方便的方法完成读写功能

处理流使用了修饰器设计模式，不会数据源相连。

### 性能

1. 增加缓冲
2. 提供一次性输入输出大数据

### BufferedReader

内含Read属性，用于接收其他流。

~~~java
new BufferedReader(new FileInputStream(String/File));

String line;//按行接收数据,效率高

while((line = bufferedReader.readLine()) != null) {//按行读取，不包括换行符，末尾时返回null
    System.out.println(line);
}

bufferedReader.close();//关闭处理流，自动关闭被包装的流
~~~

### BufferedWriter

~~~java
new BufferedWriter(new FileOutputStream(String/File, boolean));

write(String);
newLine();//根据操作系统添加换行符

close();
~~~

### Buffered读写示例

~~~java
import java.io.*;
public class BufferedCopy_ {
    public static void main(String[] args) {
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a2.java";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //说明: readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
            }
            System.out.println("拷贝完毕...");
        } 
        catch (IOException e) {
            
        } 
        finally {
            //关闭流
            try {
                if(br != null) br.close();
                if(bw != null) bw.close();
            } 
            catch (IOException e) {
                
            }
        }
    }
}
~~~

### BufferedInputStream与BufferedOutputStream

内含缓冲数组

~~~java
package com;
import java.io.*;
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a3.java";

        //创建BufferedOutputStream对象BufferedInputStream对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //因为 FileInputStream  是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回 -1 时，就表示文件读取完毕
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }
            System.out.println("文件拷贝完毕~~~");
        } 
        catch (IOException e) {
        } 
        finally {
            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            try {
                if(bis != null) bis.close();
                if(bos != null) bos.close();
            catch (IOException e) {
            }
        }
    }
}
~~~

### 总结

二进制文件的读写操作继承于父类，主要的提升是缓冲的存在。

文本文件的读写操作主要的提升是提供了额外功能：按行读取和添加换行符的操作。

## 对象流

### 序列化与反序列化

序列化就是保存数据时，保存数据的值和类型

反序列化就是恢复数据时，恢复数据的值和类型



### 序列化机制

通过实现`Serializable`或`Externalizable`接口来成为可序列化。

一般用`Serializable`接口实现，因为这个接口中不需要重写方法，而另一个需要重写方法。

### ObjectOutputStream

提供序列化功能

~~~java
new ObjectOutputStream(new FileOutputStream(String/File, boolean));

writeInt(100);
writeBoolean(true);
writeDouble(3.14);
writeChar('H');
writeUTF("hello");
writeObject(自定义对象);

close();
~~~





### ObjectInputStream

提供反序列化功能

~~~java
new ObjectInputStream(new FileInputStream(String/File));

readInt();
readBoolean();
readDouble();
readChar();
readUTF();
readObject();

close();
~~~



### 注意事项

1. 读写的顺序要一致
2. 序列化和反序列化对象需要实现`Serializable`接口
3. 序列化类中建议建议添加`SerialVersionUID`，提高版本兼容性
4. 序列化对象中，默认将所有属性进行序列化。除了`static`和`transient`修饰的成员
5. 序列化对象中，其中用于接收其他类对象的属性，所接收的类也得实现`Serializable`
6. 序列化也具备继承性。父类是可序列化，那么子类也可序列化

关于序列化详解的[文章](https://www.cnblogs.com/9dragon/p/10901448.html)



## 标准输入输出流

~~~java

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class InputAndOutput {
    public static void main(String[] args) {
        //System 类 的 public final static InputStream in = null;
        // System.in 编译类型   InputStream
        // System.in 运行类型   BufferedInputStream
        // 表示的是标准输入 键盘
        System.out.println(System.in.getClass());

        //老韩解读
        //1. public final static PrintStream out = null;
        //2. 编译类型 PrintStream
        //3. 运行类型 PrintStream
        //4. 表示标准输出 显示器
        System.out.println(System.out.getClass());
        System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        String next = scanner.next();
        System.out.println("next=" + next);
        
        
        
        //我们可以去修改打印流输出的位置/设备
        System.setOut(new PrintStream("e:\\f1.txt"));//此时输出到制定文件中
        System.out.println("hello");
    }
}
~~~

## 打印流

只有输出流，

~~~java
package com.hspedu.printstream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * 演示PrintStream （字节打印流/输出流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
        out.print("john, hello");
        //因为print底层使用的是write(), 所以我们可以直接调用write进行打印/输出，本质是一样的
        out.write("韩顺平,你好".getBytes());
        out.close();
    }
}
~~~

~~~java
package com.hspedu.transformation;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 演示 PrintWriter 使用方式
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hello");
        printWriter.close();//flush + 关闭流, 才会将数据写入到文件..
    }
}
~~~



## 转换流

~~~java
BufferedReader bufRead = new InputStreamReader(new FileInputStreasm(String/File), "utf-8");
String s = bufRead.readLine();
bufRead,close();

BUfferedWriter bufWrite = new OutputStreamWriter(new FileOutputStream(String/File),"utf-8");
bufWrite.write("hello");
bufWrtite.close();
~~~

## Properties

是专门用于读写配置文件的集合类

配置文件格式：`键=值`。其中键值对之间没有空格，值不需要引号，默认类型String。

~~~java
new Properties();//创建对象

properties.load(Reader/InputStream);//加载配置文件到properties对象

list(PrintStream/PrintWriter);//指定显示数据的设备位置

getProperty(key);
seteProperty(key, value);//key存在时，替换value

store(Writer/OutputStream, String);//保存对象中的数据到配置文件中，其中String作为标注放在配置文件开头

~~~

~~~java
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来读取mysql.properties 文件
        //1. 创建Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3. 把k-v显示控制台
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);
    }
}
~~~


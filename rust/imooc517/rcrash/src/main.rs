//! 语法练习
mod mod11;
mod mod22;
// const A_CONST:i32 = 42 + 2 - 2;
fn main() {
    // let mut x = 5;
    // println!("the value of x is {}",x);
    // x = 7;
    // println!("the value of x is {}",x);
    // println!("the value of A_CONST is {}",A_CONST);
    // let x = x * x;//shadowing 隐藏
    // println!("the value of x is {}",x);

    assert_eq!(avg(4294967295, 4294967295), 4294967295);
    assert_eq!(avg(0, 0), 0);
    assert_eq!(avg(10, 20), 15);
    assert_eq!(avg(4294967295, 1), 2147483648);
    println!("passed");

    test_overflow(4294967295, 2);
    println!("--------my_tuple--------");
    my_tuple();
    println!("--------my_array--------");
    my_array();
    println!("--------my_slice--------");
    my_slice();
    println!("--------my_stuct--------");
    my_stuct();
    println!("--------my_enum--------");
    my_enum();
    println!("--------my_print--------");
    my_print();
    println!("--------tran_type--------");
    tran_type();
    println!("--------if_loop--------");
    if_loop();
    println!("--------my_match--------");
    my_match();

    println!("--------search--------");
    let arr = vec![-1, 0, 3, 5, 9, 12];
    let target: i32 = 9;
    let i: i32 = search(arr, target);
    println!("{}", i);
    println!("--------fibonacci--------");
    println!("{}", fibonacci(10));
    println!("--------method--------");
    let mut p = Point::new(10, 20); //没有对象直接使用结构体中的函数
    println!("{:?}", p);
    p.set_x(33);
    println!("p.x = {}", p.get_x()); //实例的对象使用函数
                                     /* 闭包 |...|-> */
    let times3 = |n: u32| -> u32 { n * 3 };
    println!("time 3 = {}", times3(20));
    /* move:将环境中的值移到闭包内部 */
    // let hello_message = "Hello World!";
    // std::thread::spawn(move || {
    //     println!("{}", hello_message);
    // })
    // .join();
    println!("--------calc--------");
    println!("{}", calc(add, 2, 3));
    println!("{}", calc(sub, 2, 3));
    println!("{}", calc2("add")(3, 3)); //calc2返回一个函数

    println!("--------foo--------");
    // foo();

    println!("--------mod--------");
    println!("{}", mod1::MESSAGE);
    println!("{}", mod1::mod2::MESSAGE);
    println!("{}", mod1::CrateEnum::Item as u32);
    mod1::mod2::say432();
    println!("--------struct pub--------");
    let mut p = mod1::People::new("jack", "sb");
    p.set_nickname("dsb");
    let nickname = p.get_nickname();
    println!("{}'s nickname is {}", p.name, nickname);

    println!("--------mod files--------");
    println!("{}", mod11::MSG);
    println!("{}", mod22::MSG);
    println!("{}", mod22::mod22_a::MSG22A);


    println!("--------泛型--------");
    println!("{}",largest(2,3));
    let a = PointT{x:2,y:3};
    println!("a.largest:{:?}",a.largest());
    let c = PointT{x:3_f64,y:4_f64};
    show_point(&c);
    println!("c.modulus_length:{:?}",c.modulus_length());
    let d = PointT{x:12_f64,y:5_f64};
    show_point_new(d);
    let b = PointT{x:4,y:6};
    let line = Line{a,b};
    println!("line:{}",line);

    println!("--------所有权--------");
    //一个值只有一个所有者
    let v1 = String::from("v1 val");
    let v2 = v1;
    println!("v1:{}",v2);
    // println!("v1:{}",v1); //所有权已经移交给v2了

    let s2: String;
    {
        let s1 = String::from("s1 val");
        s2 = s1;
        // println!("s1:{}",s1); //value borrowed here after move
        println!("s2:{}",s2);
    }
    println!("s2:{}",s2);
}

fn avg(a: u32, b: u32) -> u32 {
    // if b > a {
    //     return a + (b - a) / 2;
    // }
    // b + (a - b) / 2
    (a & b) + ((a ^ b) >> 1)
}

fn test_overflow(a: u32, b: u32) {
    let (sum, is_overflow) = a.overflowing_add(b);
    println!("sum is :{},is overlows: {}", sum, is_overflow);
    let (mul, is_overflow) = a.overflowing_mul(b);
    println!("mul is :{},is overlows: {}", mul, is_overflow);
}

/* 元组 */
fn my_tuple() {
    let a = 233;
    let b = '我';
    let mt = (a, b);

    let (c, d) = mt;
    println!("{} {}", c, d);

    println!("{} {}", mt.0, mt.1);
}

/* 数组 */
fn my_array() {
    let my_array: [u32; 10] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];

    // let i = "10".parse::<usize>().unwrap();
    println!("1st is :{}", my_array[0]);

    let mut buffer: [u32; 32 * 1024] = [233; 32 * 1024];
    buffer[1024] = 666;
    println!("buffer[1024]:{}", buffer[1024]);
}

/* 切片 */
fn my_slice() {
    let mut arr: [i32; 6] = [1, 2, 3, 4, 5, 6];
    let slice = &arr[0..1]; // .. rust的range语法 [m,n);&是引用符号

    println!("slice[0] is = {}; len = {}", slice[0], slice.len());
    println!("slice is = {:?}", slice);

    let slice_2 = &arr[3..6];
    println!("slice_2 is = {:?}", slice_2);

    let slice_3 = &mut arr[..];
    slice_3[0] = 233;
    println!("arr[0] = {}", arr[0]);
}

/* 结构体 */

/* 元组结构体 */
struct Pair(i32, f32);

/* C结构 */
#[derive(Debug)] //派生属性
struct Person {
    name: String,
    age: u8,
}

/* 单元结构（无字段） */
#[derive(Debug)]
struct Unit;

fn my_stuct() {
    let pair = Pair(10, 4.2);
    println!("pair.0 = {}", pair.0);

    let jack = Person {
        name: String::from("jack"),
        age: 6,
    };
    println!("{} is {}", jack.name, jack.age);
    println!("{:?}", jack);

    let unit = Unit;
    println!("{:?}", unit);
}

/* 枚举 enum */
/* 带值的枚举 */
#[derive(Debug)]
enum Color {
    Red = 0xff0000,
    Green = 0x00ff00,
    Blue = 0x0000ff,
}

/* 带参数的枚举 */
enum IpAddr {
    IPv4(u8, u8, u8, u8),
    IPv6(
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
        u8,
    ),
}

/// 枚举例子
/// ```
/// `///`是文档注释
/// my_enum();
/// 1. 123
/// 2. 123
/// 3. 123
/// ```
fn my_enum() {
    let localhost: IpAddr = IpAddr::IPv4(127, 0, 0, 1);
    match localhost {
        IpAddr::IPv4(a, b, c, d) => {
            println!("localhost is {}.{}.{}.{}", a, b, c, d)
        }
        IpAddr::IPv6(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p) => {
            println!(
                "localhost is {}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}",
                a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p
            )
        }
    }
    let localhost: IpAddr = IpAddr::IPv6(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    match localhost {
        IpAddr::IPv4(a, b, c, d) => {
            println!("localhost is {}.{}.{}.{}", a, b, c, d)
        }
        IpAddr::IPv6(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p) => {
            println!(
                "localhost is {}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}.{}",
                a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p
            )
        }
    }
    let red = Color::Red;
    let blue = Color::Blue;
    let green = Color::Green;
    println!("red is {:?}", red);
    println!("blue is {:?}", blue);
    println!("green is {:?}", green);
}

///使用`println!()`宏
fn my_print() {
    // 可以使用额外的位置参数.
    println!("{0}{1}{0}", 4, 2);

    // 使用命名参数.
    println!("name={name} age={age}", name = "jack", age = 6);

    // 可以在 `:` 后面指定特殊的格式.
    println!("{} of {:b} people know binary, the other half don't", 1, 2);

    // 可以按指定宽度来右对齐文本.
    println!("{number:>width$}", number = 1, width = 6);

    // 在数字左边补 0.下面语句输出 "000001".
    println!("{number:>0width$}", number = 1, width = 6);

    // println! 会检查使用到的参数数量是否正确.
    // println!("My name is {0}, {1} {0}", "Bond");
    // 编译将会报错, 请补上漏掉的参数："James"
}

/* 类型转换 */
fn tran_type() {
    let a: i8 = -10;
    let b = a as u8;
    println!("a:{},b:{}", a, b);
    unsafe {
        let c = [0u8, 1u8, 0u8, 0u8];
        /*
            non-primitive cast: `[u8; 4]` as `u32`
            an `as` expression can only be used to convert between primitive types or to coerce to a specific trait
        */
        // let d = c as u32;

        //std::mem::transmute()不安全的强制类型转换,要求转换前后变量长度相同
        let d: u32 = std::mem::transmute(c);
        let e: u8 = std::mem::transmute(a);
        println!("d:{},e:{}", d, e);
    }
}

/* 表达式 */
/// expression 表达式
/// statement  语句  没有返回值(声明语句)
fn if_loop() {
    let n = 233;
    let mut m = n;
    if n > 0 {
        println!("{} > 0", n);
    } else {
        m = 0;
    }

    //这里需要两个分支返回相同类型
    let o = if m == 0 {
        m
    } else {
        println!("n -> {}", n);
        n
    };
    println!("m:{},o:{}", m, o);

    //loop
    let mut sum = 0;
    let mut num = 1;
    sum = loop {
        sum = sum + num;
        num = num + 1;
        if num > 100 {
            break sum;
        }
    };

    println!("sum:{}", sum);

    //while
    //fizz buzz
    let mut nn = 1;
    while nn < 101 {
        if nn % 15 == 0 {
            print!("fizzbuzz ");
        } else if nn % 3 == 0 {
            print!("fizz ");
        } else if nn % 5 == 0 {
            print!("buzz ");
        } else {
            print!("{} ", nn);
        }
        nn += 1;
    }
    println!();

    //for...in...
    //a..b创建范围是[a,b)步长为1的迭代器
    //a..=b创建范围是[a,b]步长为1的迭代器
    for i in 0..5 {
        print!("{} ", i);
    }
    println!();
    for i in 0..=5 {
        print!("{} ", i);
    }
    println!();
    // for ... in ...迭代数组
    let arr = ['a', 'b', 'c'];
    for c in arr.iter() {
        print!("{:?} ", c);
    }
    println!();

    let mut arr1 = [0, 1, 2, 3, 4];
    for nu in arr1.iter_mut() {
        *nu = *nu * 2; //解引用
    }
    for nu in arr1.iter() {
        print!("{:?} ", nu);
    }
    println!();
}

/* match */
fn my_match() {
    #[derive(Debug)]
    enum Alphabet {
        A,
        B,
    }
    let mut letter = Alphabet::A;

    match letter {
        Alphabet::A => {
            println!("It is {:?}", letter);
        }
        Alphabet::B => {
            println!("It is {:?}", letter);
        }
    }
    letter = Alphabet::B;
    //if let语法糖 相当于match匹配一项,忽略其他
    if let Alphabet::B = letter {
        println!("It is {:?}", letter);
    };

    //匹配数字
    let opcode: u8 = 42;
    match opcode {
        42 => {
            println!("ok");
        }
        _ => {
            println!("aqwerqwerw");
        }
    }

    enum Symbol {
        Char(char),
        Number(i32),
    }
    let s = Symbol::Char('A');
    let n = Symbol::Number(233);

    if let Symbol::Char(x) = n {
        println!("{:?}", x);
    }
    if let Symbol::Char(x) = s {
        println!("{:?}", x);
    }

    //while let语法糖
    println!("----while let-----");
    // let letter1 = Alphabet::B;
    let letter1 = Alphabet::A;
    let mut i = 0;
    while let Alphabet::A = letter1 {
        println!("{:?}", letter1);
        i += 1;
        if i > 10 {
            break;
        }
    }
}

/* 函数 方法 */
fn search(nums: Vec<i32>, target: i32) -> i32 {
    let mut l: usize = 0;
    let mut r: usize = nums.len() - 1;
    let mut m: usize = 0;
    println!("{}", m);
    while l <= r {
        // println!("l & r:{}, (l ^ r) >> 1:{}",(l & r),((l ^ r) >> 1));
        // m = (l & r) + ((l ^ r) >> 1);// l + (r - l) / 2;
        m = (l + r) / 2;
        println!("{:?}", m);
        if target == nums[m] {
            return m as i32;
        } else if target > nums[m] {
            l = m + 1;
        } else {
            r = m - 1;
        }
    }
    return -1;
}
// 函数
fn fibonacci(n: u64) -> u64 {
    if n < 2 {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}

//方法 对象的函数
#[derive(Debug)]
struct Point {
    x: u64,
    y: u64,
}

impl Point {
    fn new(x: u64, y: u64) -> Point {
        Point { x, y }
    }

    fn get_x(&self) -> u64 {
        self.x
    }

    fn set_x(&mut self, x: u64) {
        self.x = x
    }
}

/* 高阶函数 1. 接收一个或多个函数为参数; 2. 返回一个函数 */
type MethodCalc = fn(u32, u32) -> u32; //为类型取别名
                                       // fn calc(method: fn(u32, u32) -> u32, a: u32, b: u32) -> u32 {
fn calc(method: MethodCalc, a: u32, b: u32) -> u32 {
    method(a, b)
}

fn add(x: u32, y: u32) -> u32 {
    x + y
}
fn sub(x: u32, y: u32) -> u32 {
    if x > y {
        x - y
    } else {
        0
    }
}

fn calc2(method: &str) -> MethodCalc {
    match method {
        "add" => add,
        "sub" => sub,
        _ => unimplemented!(),
    }
}

/* 发散函数 永远都不被返回的函数 返回!表示空类型*/
// fn foo() -> ! {
//     panic!("this call never returns.");
// }

mod mod1 {
    //默认成员是私有的
    pub const MESSAGE: &str = "hello mod1!";
    pub(self) const NUMBER: u32 = 432;

    pub mod mod2 {
        pub const MESSAGE: &str = "hello mod2!";

        pub fn say432() {
            println!("{}", super::NUMBER);
        }
    }

    //pub(crate)在整个crate中可以被调用
    pub(crate) enum CrateEnum {
        Item = 4,
    }

    pub struct People {
        pub name: String,
        nickname: String,
    }

    impl People {
        ///构造方法
        pub fn new(name: &str, nickname: &str) -> Self {
            People {
                name: String::from(name),
                nickname: String::from(nickname),
            }
        }

        ///返回`nickname`
        pub fn get_nickname(&self) -> String {
            self.nickname.clone()
        }

        ///修改外号 需要对象是可变的
        pub fn set_nickname(&mut self, new_nickname: &str) {
            self.nickname = String::from(new_nickname);
        }
    }
}

/// 使用泛型
fn largest<T: std::cmp::PartialOrd>(a: T, b: T) -> T {
    if a > b {
        a
    } else {
        b
    }
}

struct PointT<T>{
    x:T,
    y:T,
}

// struct PointTU<T,U>{
//     x:T,
//     y:T,
//     z:U,
// }

impl<T: Clone + std::cmp::PartialOrd> PointT<T> {
    pub fn largest(&self) -> T {
        if self.x > self.y {
            self.x.clone()
        } else {
            self.y.clone()
        }
    }
}


//针对`f64`类型的方法
impl PointT<f64>{
    pub fn modulus_length(&self) -> f64 {
        (self.x * self.x + self.y * self.y).sqrt()
    }
}

//实现打印方法
impl<T: std::fmt::Display> std::fmt::Display for PointT<T> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result{
        write!(f,"({}, {})",self.x,self.y)
    }
}

fn show_point<T: std::fmt::Display>(a:T) {
    println!("show: {}",a);
}

fn show_point_new(a: impl std::fmt::Display) {
    println!("show_new: {}",a);
}

struct Line<T>{
    a:PointT<T>,
    b:PointT<T>
}
impl<T: std::fmt::Display> std::fmt::Display for Line<T> {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result{
        write!(f, "[{}, {}]", self.a, self.b)
    }
}
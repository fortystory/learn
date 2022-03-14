//导入fmt模块,使fmt::Display可用
use std::fmt;

//定义一个简单的元组结构体
//用以实现fmt::Display
struct Structure(i32);

//为了使用{}标记,必须手动为类型实现fmt::Display trait
impl fmt::Display for Structure{
    fn fmt(&self,f: &mut fmt::Formatter) -> fmt::Result{
        //仅将self的第一个元素写入到指定的输出流f,返回fmt::Result,
        //此结果表明操作成功或失败.注意write!的用法和println!很相似
        write!(f,"val:{}",self.0)
    }
}


// 带有两个数字的结构体,推导出Debug,以便与Display的输出进行比较
#[derive(Debug)]
struct MinMax(i64,i64);

// 实现MinMax的Display
impl fmt::Display for MinMax{
    fn fmt(&self,f:&mut fmt::Formatter)->fmt::Result{
        //使用self.number来表示各个数据
        write!(f,"({},{})",self.0,self.1)
    }
}

// 比较带有具名字段的结构体
#[derive(Debug)]
struct Point2D{
    x:f64,
    y:f64
}

impl fmt::Display for Point2D{
    fn fmt(&self,f:&mut fmt::Formatter) -> fmt::Result{
        write!(f,"x:{}, y:{}",self.x,self.y)
    }
}


//复数
#[derive(Debug)]
struct Complex{
    real: f64,
    imag: f64
}

impl fmt::Display for Complex{
    fn fmt(&self,f:&mut fmt::Formatter) -> fmt::Result{
        write!(f,"{} + {}i",self.real,self.imag)
    }
}


//定义一个包含单个Vec的结构体List
struct List(Vec<i32>);
impl fmt::Display for List{
    fn fmt(&self, f:&mut fmt::Formatter) -> fmt::Result{
        //使用元组的下标获取值,并创建一个vec的引用
        let vec = &self.0;
        //对write!进行尝试(try),若发生错误,返回相应的错误.
        //否则(没错的话)继续执行后面的语句
        writeln!(f,"[")?;// 这个问号相当于try! 当前语句相当于:try!(write!(f,"{}",value));

        //使用v对vec进行迭代,并用count记录迭代次数
        for(count,v)in vec.iter().enumerate(){
            if count != 0 {writeln!(f,", ")?;}
            write!(f,"  [{}] => {}",count,v)?;
        }

        //加上配对的括号,并返回一个fmt::Result值
        println!();
        writeln!(f,"]")
    }
}

fn main() {
    println!("Hello, print_display!");
    //fmt::Display采用{}来标记
    let s = Structure(233);
    println!("{}",s);


    let minmax = MinMax(0,14);
    println!("Compare structures:");
    println!("Display {}",minmax);
    println!("Debug {:?}",minmax);


    let big_range = MinMax(-300,300);
    let sma_range = MinMax(-3,3);

    println!("The big range is {big} and the small range is {small}",small=sma_range,big=big_range);



    let point = Point2D{x:3.3,y:7.2};
    println!("Compare points:");
    println!("Display {}",point);
    println!("Debug {:?}",point);
    //println!("Dinary {:b}",point);
    
    let complex = Complex{real:233f64,imag:666f64};
    println!("Compare complex:");
    println!("Display {}",complex);
    println!("Debug {:?}",complex);


    let l = List(vec![1,2,3,4,5,6]);
    println!("{}",l);
}

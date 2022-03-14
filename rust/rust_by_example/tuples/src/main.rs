use core::fmt;

/// 元组可以充当函数的参数和返回值
fn reverse(pair:(i32,bool)) -> (bool,i32){
    //可以使用let把一个元组的成员绑定的一些变量上
    let (integer,boolean) = pair;
    (boolean,integer)
}
/// 矩阵结构体
struct Matrix(f32,f32,f32,f32);

impl fmt::Display for Matrix{
    fn fmt(&self,f:&mut fmt::Formatter) -> fmt::Result{
        write!(f,"\n({},{})\n({},{})",self.0,self.1,self.2,self.3)
    }
}

impl Matrix{
    /// 为矩阵(`Matrix`)添加转换(`transpose`)方法
    fn transpose(&mut self) -> &mut Matrix{
        let t = self.1;
        self.1 = self.2;
        self.2 = t;
        return self;
    }
}

fn main() {
    println!("Hello, tuples!");

    //包含各种不同类型的元组
    let long_tuple = (
        1u8,2u16,3u32,4u64,
        -1i8,-2i16,-3i32,-4i64,
        0.1f32,0.2f64,
        'a',true
    );

    //通过元组的下标来访问具体的值
    println!("long tuple first value: {}",long_tuple.0);
    println!("long tuple second value: {}",long_tuple.1);

    //元组可以嵌套
    let tuple_of_tuple = (
        (1u8,2u16,3u32,4u64,),
        ( -1i8,-2i16,-3i32,-4i64,),
        0.1f32,0.2f64,
    );

    //元组打印
    println!("tuple_of_tuple : {:?}",tuple_of_tuple);
    //很长的元组不能进行打印
    // let too_long_tuple = (1,2,3,4,5,6,7,8,9,0,11,22,33,44,55,66,77,88,99,00);
    // println!("too_long_tuple : {:?}",too_long_tuple);

    let pair = (1,true);
    println!("pair is {:?}",pair);
    println!("reversed pair is {:?}",reverse(pair));


    //单一元素元组需要额外的逗号
    println!("one element tuple: {:?}",(5u32,));
    println!("just an integer: {}",(5u32));


    //元组解构 deconstruct 将值绑定给变量
    let tuple = (1,"hello",4.5,true);
    let (a,b,c,d) = tuple;

    println!("{:?},{:?},{:?},{:?}",a,b,c,d);


    let mut matrix = Matrix(1f32,2f32,3f32,4f32);
    println!("matrix:{}",matrix);
    println!("matrix:{}",matrix.transpose());



    println!("Talk is cheap. Show me the code.");    



}

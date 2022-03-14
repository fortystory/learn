//不能使用`fmt::Display`或`fmt:Debug`来进行打印
//struct UnPrintable(i32);

//'derive'属性会自动创建所需的实现,使这个'struct'能使用'fmt::Debug'进行打印
//#[derive(Debug)]
//struct DebugPrintable(i32);




//推导`Structure`的`fmt::Debug`实现
//`Structure`是一个包含单个`i32`的结构体
#[derive(Debug)]
struct Structure(i32);

//将`Structure`放到结构体`Deep`中.使用`Deep`也能够打印
#[derive(Debug)]
struct Deep(Structure);


#[derive(Debug)]
struct Person<'a>{
    name:&'a str,
    age:u8
}
fn main() {
    //使用`{:?}`打印和使用`{}`打印类似
    println!("{:?} months in a year.",12);
    println!("{1:?} {0:?} is the {actor:?} name.","Slater","Chistian",actor="actor's");

    //打印Structure
    println!("now {:?} will print!",Structure(233));

    //使用`derive`不能控制打印形式
    println!("now {:?} will print!",Deep(Structure(666)));


    //通过`{:#?}`进行美化打印
    let name = "peter";
    let age = 27;
    let peter = Person{name,age};

    //美化打印
    println!("{:#?}",peter);
    println!("name:{},age:{}",peter.name,peter.age);
}

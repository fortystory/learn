fn main() {
    // 行注释

    /*
        块注释
    */
    p();
    q();
    println!("Hello, world!");
}

/// 文档注释
/// 支持`markdown`语法
fn p(){
    println!("hello p!");
}

// //! 生成文档的注释
fn q(){
    println!("hello q!");
}

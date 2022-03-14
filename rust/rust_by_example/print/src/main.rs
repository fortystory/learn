fn main() {
    //打印操作由std::fmt里面一系列宏来处理:
    //format!   :将格式化文本写入字符串返回
    //print!    :将格式化文本输出到控制台 io::stdout
    //println!  :与println!类似,但会追加一个换行符
    //eprint!   :与println!类似,但会将文本输出到标准错误 io::stderr
    //eprintln! :与eprint!类似,会追加换行符




    println!("打印宏");

    //通常情况下"{}"会被任意变量内容转换为字符串然后替换
    println!("Hello, world{}","!");


    //使用位置参数
    println!("{0}, this is {1}. {1}, this is {0}","Alicia","Diane");

    //使用命名参数
    println!("{subject} {verb} {object}",object="the lazy dog", subject="the quick brown fox",verb="jumps over");

    //可以在:后指定特殊格式
    println!("{} of {:b} people know binary, the other half don't.",1,2);

    //指定宽度
    println!("{number:<width$}",number=1,width=6);
    println!("{number:>width$}",number=1,width=6);
    //补0
    println!("{number:>0width$}",number=1,width=6);
    println!("{number:0<width$}",number=1,width=6);

    //检查参数数量
    println!("My name is {0}, {1} {0}","Bond","Jim");


    //截取3位小数
    let pi = 3.141592;
    println!("Pi is roughly {:.*}",3,pi);
}

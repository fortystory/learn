fn main() {
    let mut str = String::from("hello echo");
    println!("{}",str);
    echo (&mut str);
    println!("{}",str);
}

fn echo(s:&mut String){
    s.push_str("abc");//追加字符串
}
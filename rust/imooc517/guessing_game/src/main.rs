use rand::Rng;
use std::io as si;//使用as为路径取别名

fn main() {
    println!("Guess The Number!");
    let secret_number:u32 = rand::thread_rng().gen_range(1..101);
    // println!("secret_number:{}",secret_number);

    loop {
        //获取输入
        println!("Input your guess:");
        let mut guess = String::new();
        si::stdin().read_line(&mut guess).unwrap();

        let guess_number:u32 = match guess.trim().parse(){
            Ok(num) => num,
            Err(_err) => continue,
        };

        println!("Input your guess is:{}",guess_number);
        //判断大小
        if guess_number > secret_number {
            println!("Too big!");
        } else if guess_number < secret_number {
            println!("Too small!");
        } else{
            println!("Right!!");
            break;
        }
    }
}

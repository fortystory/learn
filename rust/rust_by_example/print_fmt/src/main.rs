use std::fmt::{self,Formatter,Display};

struct City{
    name:&'static str,
    //纬度
    lat:f32,
    //经度
    lon:f32
}

impl Display for City{
    //f是一个缓冲区(buffer),此方法必须将格式化后的字符串写入其中
    fn fmt(&self,f:&mut Formatter) -> fmt::Result{
        let lat_c = if self.lat >= 0.0 {'N'} else {'S'};
        let lon_c = if self.lon >= 0.0 {'E'} else {'W'};
        //wriat!和format!类似,但它会将格式化后的字符串写入一个缓冲区(即第一个参数f)中
        write!(f,"{}: {:.3}°{},{:.3}°{}",self.name,self.lat.abs(),lat_c,self.lon.abs(),lon_c)
    }
}

#[derive(Debug)]
struct Color{
    red:u8,
    green:u8,
    blue:u8,
}

impl Display for Color{
    fn fmt(&self,f:&mut Formatter) -> fmt::Result {
        //{:X}格式化为十六进制数字
        write!(f,"RGB ({red:03}, {green:03}, {blue:03}) 0x{red:02X}{green:02X}{blue:02X}",red=self.red,blue=self.blue,green=self.green)
    }
}

fn main() {
    //let foo:i64 = 3735928559;
    //format!("{}",foo);
    for city in [
        City{name:"Dublin",lat: 53.347778, lon: -6.259722},
        City{name:"Dublin",lat: -53.347778, lon: 6.259722},
        City{name:"Dublin",lat: 0.0000000, lon: 0.0000000},
    ].iter() {
        println!("{}",*city);//如果要使用{} 进行打印.需要实现Display
    }


    for color in [
        Color{red:255,green:255,blue:255},
        Color{red:1,green:2,blue:3},
    ].iter(){
        //println!("{:?}",*color);
        println!("{}",*color);
    }
}

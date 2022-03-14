fn main() {
    println!("0011 AND 0101 is {:04b}",0b0011u32 & 0b0101u32); println!("0011 O R 0101 is {:04b}",0b0011u32 | 0b0101u32); println!("0011 XOR 0101 is {:04b}",0b0011u32 ^ 0b0101u32);
    println!("{:b} << {:b} is {:04b}",1u32,5u32,1u32 << 5u32);
    println!("0x80 >> 2 is 0x{:x}",0x80u32 >> 2);
}

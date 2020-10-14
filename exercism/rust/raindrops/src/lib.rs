pub fn raindrops(n: u32) -> String {
    let res: String = [(3, "Pling"), (5, "Plang"), (7, "Plong")]
        .iter()
        .filter(|(e, _)| n % e == 0)
        .map(|&(_, s)| s)
        .collect();
    match res.is_empty() {
        true => n.to_string(),
        false => res,
    }
}

pub fn raindrops2(n: u32) -> String {
    let mut res = String::new();

    let parameters = [(3, "Pling"), (5, "Plang"), (7, "Plong")];

    for p in &parameters {
        if n % p.0 == 0 {
            res.push_str(p.1)
        }
    }

    if res.is_empty() {
        res = n.to_string()
    }
    res
}

pub fn raindrops1(n: u32) -> String {
    let mut result = String::from("");
    if n % 3 == 0 {
        result = result + "Pling";
    }

    if n % 5 == 0 {
        result += "Plang";
    }

    if n % 7 == 0 {
        result += "Plong";
    }

    if result.is_empty() {
        result = n.to_string();
    }
    result
}

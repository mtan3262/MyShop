select l."TenLoai"
from "Sach" as s, "LoaiSach" as l
where "MaSach" = /*MaSach*/ and s."MaLoai" = l."MaLoai"
### Đây là bài giữa kỳ môn công nghệ JAVA
Các thành phần của project 

    File Shoe chứa source code để chạy chương trình
    File database chứa file sql của chương trình, mô hình quan hệ , mô hình erd của chương trình
Sau đây là hướng dẫn để có thể chạy chương trình 
1. Cần thiết lập database trong website này được thực hiện bằng mysql 
   1. Tạo một database tên là shoe sau đó import file sql được lưu ở thư mục database
   2. Sau đó thiết lập kết nối với database trong file application.properties
2. Download project về máy và chạy chương trình 

*Lưu ý*: trong project này em sử dụng java 17 hãy đảm bảo rằng máy của bạn có nó.

Mô tả về Website :

    Website sử dụng templates free của https://colorlib.com/

    Website chỉ có giao diện tương tác giữa khách hàng và server 
    Website có phần font-end cho phía khách hàng.
    Các chức năng chính của Web cho là:
        Ở phía khách hàng
            - Trang chủ hiện thị thông tin sản phẩm cho khách hàng 
            - Search sản phẩm 
            - Liệt kê sản phẩm theo từng loại sản phẩm
            - Xem chi tiết sản phẩm 
            - Liệt kê sản phẩm theo loại sản phẩm và theo hãng
            - Khách hàng có thể thêm sản phẩm vào giỏ hàng, đặt hàng, xem giỏ hàng, xem lịch sử đặt hàng, tình trạng đơn hàng.
            - Đăng nhập và đăng ký cho khách hàng
        Ở phía admin 
            - Có thể xem các đơn đặt hàng của khách hàng , thay đổi trạng thái của đơn hàng.
            - CRUD loại sản phẩm, hãng sản phẩm, sản phẩm,màu của sản phẩm,size sản phẩm
Dưới đây là lệnh và ảnh chụp  ví dụ của postman về việc request các api
----------------------------------------------------------------

### CRUD  Brand:
    
- Lấy tất cả thông tin của brand
     
     - url: GET http://localhost:8080/admin/brand/getAll
    
     - ảnh chụp:

     ![markdown](images/brandall.png)
-  Lấy thông tin của một brand theo id
    
    - url :GET http://localhost:8080/admin/brand/getBrand/{id}

    trong đó {id} là id của brand

   -  ảnh chụp  ví dụ :
    ![markdown](images/1680761560339.png)

- Thêm một brand vào database 
   -  url : POST http://localhost:8080/admin/brand/addbrand 

   - ảnh chụp:
  ![markdown](images/1680761892070.png)
  *Lưu ý:* Việc đặt tên biến phải giống với tên biến như trong hình thì mới có thể thực hiện request 
-   Update brand  
    - url : POST  http://localhost:8080/admin/brand/updateBrand
    - ảnh chụp
    ![markdown](images/1680764655537.png)
- Delete brand 
  - url : DELETE http://localhost:8080/admin/brand/deleteBrand/{id}
   trong đó {id} là id của brand
   - ảnh chụp:
   ![markdown](images/1680762372509.png)
   *Lưu ý:* Việc xóa brand sẽ đồng nghĩa với việc xóa luôn các sản phẩm thuộc brand đó
   ----------------------------------------------------------------

### CRUD Genre 
- Lấy tất cả thông tin của genre
  - url : GET http://localhost:8080/admin/genre/getAll
  - ảnh chụp
    ![markdown](images/1680764006339.png)
- Lấy thông tin của một genre
  - url : GET http://localhost:8080/admin/genre/getGenre/{id}
  trong đó {id} là id của genre
  - ảnh chụp
  ![markdowu](images/1680764212477.png)
- Thêm một genre vào database
    - url : POST http://localhost:8080/genre/addGenre
    - ảnh chụp  ví dụ 
    ![](images/1680764325938.png)
- Cập nhật thông tin của một genre
    - url : POST http://localhost:8080/admin/genre/updateGenre
    - ảnh chụp
    ![](images/1680764580691.png)
- Xóa một genre trong database
     - url : DELETE http://localhost:8080/admin/genre/deleteGenre/{id} trong đó {id }là id của genre 
    - ảnh chụp  ví dụ 
    ![](images/1680764856516.png)
    ----------------------------------------------------------------

### CRUD color
- Lấy thông tin của tất cả các color
    - url : GET http://localhost:8080/admin/color/getAll
    - ảnh chụp  ví dụ 
    ![](images/1680765100370.png)

- Lấy thông tin của một color
    - url : GET http://localhost:8080/admin/color/getColor/{id} trong đó id là id của color
    - ảnh chụp  ví dụ 
    ![](images/1680765316591.png)
- Thêm một color
  - url : POST http://localhost:8080/admin/color/addColor
  - ảnh chụp  ví dụ 
  ![](images/1680766947066.png)
- Cập nhật thông tin của Color
  - url: POST http://localhost:8080/admin/color/updateColor
  - ảnh chụp  ví dụ 
  ![](images/1680767205084.png)
- Xóa một Color
  - url: DELETE http://localhost:8080/admin/color/deleteColor/{id} trong đó id là id của Color
  - ảnh chụp  ví dụ 
  ![](images/1680767318319.png)
------------------------------------------------------------------------------------------------
### CRUD Size
- Lấy thông tin của tất cả các size
    - url : GET http://localhost:8080/admin/Size/getAll
    - ảnh chụp  ví dụ 
    ![](images/1680767585042.png)

- Lấy thông tin của một color
    - url : GET http://localhost:8080/admin/Size/getSize/{id} trong đó id là id của Size
    - ảnh chụp  ví dụ 
    ![](images/1680767614024.png)
- Thêm một color
  - url : POST http://localhost:8080/admin/Size/addSize
  - ảnh chụp  ví dụ 
  ![](images/1680767673510.png)
- Cập nhật thông tin của Size
  - url: POST http://localhost:8080/admin/Size/updateSize
  - ảnh chụp  ví dụ 
  ![](images/1680767738328.png)
- Xóa một Size
  - url: DELETE http://localhost:8080/admin/Size/deleteSize/{id} trong đó id là id của Size
  - ảnh chụp  ví dụ 
  ![](images/1680767777264.png)
----------------------------------------------------------------
### CRUD ORDER
- Lấy thông tin của tất cả các đơn hàng
  - url : GET http://localhost:8080/admin/order/getAll
  - ảnh chụp  ví dụ 
    ![](images/1680768396388.png)
- Lấy thông tin của một đơn hàng 
  - url : GET http://localhost:8080/admin/order/getDetailOrder/{id} trong đó {id} là id của đơn hàng 
  - ảnh chụp  ví dụ 
  ![](images/1680768529741.png)
- Thay đổi trạng thái của đơn hàng
  - url : POST http://localhost:8080/admin/order/changeStatus
  - ảnh chụp  ví dụ 
  ![](images/1680768766067.png)
- Xóa đơn hàng 
   - url : DELETE  http://localhost:8080/admin/order/deleteOrder/{id} trong đó {id} là id của đơn hàng 
    -   ảnh chụp
     ![](images/1680768917894.png)
- Cập nhật thông tin đơn hàng 
 - url  POST : http://localhost:8080/admin/order/updateOrder
 - ảnh chụp  ví dụ 
   ![](images/1680769720251.png)

------
### CRUD product
- Lấy thông tin của tất cả sản phẩm 
  - url GET : http://localhost:8080/admin/product/getAll
  - ảnh chụp  ví dụ 
  - ![](images/1680799330326.png) 
- Lấy thông tin chi tiết của một sản phẩm 
  - url GET http://localhost:8080/admin/product/getProductByID/{id} trong đó {id} là id của sản phẩm 
  - ảnh chụp  ví dụ 
  ![](images/1680799667704.png)
- Thêm một sản phẩm vào database
  - url POST  http://localhost:8080/admin/product/addProduct
  - ảnh chụp  ví dụ 
  - ![](images/1680799980316.png)
- cập nhật thông tin  một sản phẩm 
  - url POST  http://localhost:8080/admin/product/updateUpdate
  - ảnh chụp  ví dụ 
  - ![](images/1680800164172.png)
- Xóa một sản phẩm 
  - Url DELETE  http://localhost:8080/admin/product/deleteProduct/{id} trong đó id là mã của sản phẩm 
  - ảnh chụp
   ![](images/1680800312888.png)
- Thêm một color vào sản phẩm 
    - url POST http://localhost:8080/admin/product/addColor
    - ảnh chụp  ví dụ 
    ![](images/1680800684394.png)
- Thêm một size vào sản phẩm 
    - url POST http://localhost:8080/admin/product/addsize
    - ảnh chụp  ví dụ 
    ![](images/1680800855889.png)

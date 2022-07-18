<?php

@include 'config.php';

$id = $_GET['edit'];

if(isset($_POST['update_product'])){
    $product_name = $_POST['product_name'];
    $product_price = $_POST['product_price'];
    $product_image = $_FILES['product_image']['name'];
    $product_image_tmp_name = $_FILES['product_image']['tmp_name'];
    $product_image_folder = 'uploaded_img/'.$product_image;

    if(empty($product_name) || empty($product_price) || empty($product_image)){
        $message[] = 'please fill out all';
       
    }else{
        $update = "UPDATE product SET name='$product_name', price='$product_price', image='$product_image'where id = $id";
        $upload = mysqli_query($conn,$update);
        if($upload){
            move_uploaded_file($product_image_tmp_name,$product_image_folder);
            
        }else{
            $message[] = 'could not add the product';
        }
    }
};



?>



<!DOCTYPE html>
<html lang ="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equive="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>admin update</title>
        <!-----CSS FILE LINK----->
        <link rel="stylesheet" href="css/style.css">
    </head>
<body>

<?php

    if(isset($message)){
        foreach($message as $message){
            echo'<span class="message">'.$message.'</span>';
        }
    }
    ?>

    <div class="container">

    <?php

    $select = mysqli_query($conn,"SELECT * FROM product WHERE id = $id");
    while($row = mysqli_fetch_assoc($select)){
        
    
    ?>

        <div class="admin-product-form-container centered">
            <form action="<?php $_SERVER['PHP_SELF']?>" method="post" enctype="multipart/form-data">
            <h3>update the product</h3>
            <input type="text" placeholder="enter product name" value="<?php $row['name']; ?>" name="product_name" class="box">
            <input type="number" placeholder="enter product price" value="<?php $row['price']; ?>" name="product_price" class="box">
            <input type="file" accept="image/png, image/jpeg, image/jpg" name="product_image" class="box">
            <input type="submit" class="btn" name="update_product" value="update a product">
            <a href="admin_page.php" class="btn">go back</a>
            </form>

        <?php }; ?>
        </div>
    </div>
</body>
</html>
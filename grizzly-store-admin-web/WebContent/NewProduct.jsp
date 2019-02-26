<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addproducts">
  <div class="form-group">
    <label for="Enter Product Name"><b>Enter Product Name</b></label>
    <input type="text" class="form-control" name="name" placeholder="Product Name" >
  </div>
  <div class="form-group">
    <label for="Enter product Description"><b>Enter Product Description</b></label>
    <input type="text" class="form-control" name="description" placeholder="Description" >
  </div>
   <div class="form-group">
    <label for="Enter product Category"><b>Enter Product Category</b></label>
    <input type="text" class="form-control" name="category" placeholder="Category" >
  </div>
   <div class="form-group">
    <label for="Enter product Brand"><b>Enter Product Brand</b></label>
    <input type="text" class="form-control" name="brand" placeholder="Brand" >
  </div>
  <div class="form-group">
    <label  for="price"><b>Price</b></label>
    <input type="number" class="form-control" name="price" placeholder="Price" >
  </div>
  <div class="form-group">
    <label  for="rating"><b>Rating</b></label>
    <input type="number" class="form-control" name="rating" placeholder="Ratings" >
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>
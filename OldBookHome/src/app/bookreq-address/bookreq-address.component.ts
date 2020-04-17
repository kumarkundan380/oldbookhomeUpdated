import { Component, OnInit } from '@angular/core';
import { UserInfo, JavaServiceService } from '../java-service.service';
import { LoginServeiceService } from '../share/login-serveice.service';
import { NotificationService } from '../share/notification.service';
import { RegistrationComponent } from '../registration/registration.component';
import { MatDialogRef, MatDialog } from '@angular/material/dialog';
import { AddAddressService } from '../share/add-address.service';

@Component({
  selector: 'app-bookreq-address',
  templateUrl: './bookreq-address.component.html',
  styleUrls: ['./bookreq-address.component.css']
})
export class BookreqAddressComponent implements OnInit {

  userInfo=new UserInfo();
  isShowAddress:boolean=false;
  address:any;

  constructor(public addaddressservice:AddAddressService,
    public notificationService:NotificationService,
    public dialogRef:MatDialogRef<RegistrationComponent>,
    public dialog: MatDialog,
    public javaServiceObj:JavaServiceService ) { 
      
    }

onClear() {
this.addaddressservice.form.reset();
this.addaddressservice.initializeFormGroup();
  this.notificationService.warn(':: Clear successfully');
}

onSubmit() {
if (this.addaddressservice.form.valid) {

  this.userInfo=this.addaddressservice.form.value;
  console.log(this.userInfo);
  console.log(this.javaServiceObj.bookObj);
   this.javaServiceObj.addAddress(this.userInfo).subscribe(
    data=>{
      console.log("address add ho gaya.......");
      this.javaServiceObj.bookObj.addressId=this.address.address[this.address.address.length-1].id;

    }
  );
this.addaddressservice.form.reset();
this.addaddressservice.initializeFormGroup();
this.notificationService.success(':: Submitted successfully');
this.onClose();
}
}

onClose() {
this.addaddressservice.form.reset();
this.addaddressservice.initializeFormGroup();
this.dialogRef.close();
}
addAddress(){
  this.isShowAddress=true;
}
  ngOnInit() {
    this.javaServiceObj.getAddress().subscribe(
      (data)=>{
        this.address=data;
        console.log(this.address.address[this.address.address.length-1].id);
        // console.log(this.address.address.length);
      }
    );
  }
  sendId(id:number){
     this.javaServiceObj.bookObj.addressId=id;
     console.log(this.javaServiceObj.bookObj);
     this.javaServiceObj.requestBookDetails(this.javaServiceObj.bookObj);
  }

}

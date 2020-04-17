import { Component, OnInit } from '@angular/core';
import { UserInfo, UserLogin, JavaServiceService } from '../java-service.service';
import { LoginServeiceService } from '../share/login-serveice.service';
import { RegistrationService } from '../share/registration.service';
import { MatDialogRef, MatDialog } from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { BookSellSearchService } from '../share/book-sell-search.service';

@Component({
  selector: 'app-book-sell-search',
  templateUrl: './book-sell-search.component.html',
  styleUrls: ['./book-sell-search.component.css']
})
export class BookSellSearchComponent implements OnInit {

  constructor(public loginService: BookSellSearchService,
    public dialogRef: MatDialogRef<LoginComponent>,
    public dialog: MatDialog,
    private javaService:JavaServiceService,
    private router:Router) {

  }

  onSubmit() {
    if (this.loginService.form.valid) {
      // this.userLogin=this.loginService.form.value;
      this.javaService.bookISBN=this.loginService.form.value;
      console.log(this.javaService.bookISBN);
      this.loginService.form.reset();
      this.loginService.initializeFormGroup();
      this.onClose();
      this.router.navigate(['/booksell']);
    }
  }

  onClose() {
    this.loginService.form.reset();
    this.loginService.initializeFormGroup();
    this.dialogRef.close();
  }

  ngOnInit() {
  }

}

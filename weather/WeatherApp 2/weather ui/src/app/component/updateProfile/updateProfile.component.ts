import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { CustomvalidationService } from 'src/app/services/custom-validation.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'udpateProfile',
  templateUrl: './updateProfile.component.html',
  styleUrls: ['./updateProfile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  submitted = false;
  user:{};
  constructor(private formBuilder: FormBuilder, private customValidator: CustomvalidationService, private userService: UserService) { 
    this.user = userService.getUserDetails();
  }
  updateProfileForm = this.formBuilder.group({
    firstName:['',Validators.required],
    lastName:['',Validators.required],
    phone:['', [Validators.required]]
  }
  );

  changePasswordForm = this.formBuilder.group({
    password: ['', Validators.compose([Validators.required, this.customValidator.patternValidator()])],
    confirmPassword: ['', [Validators.required]]
  },
  {
    validator: this.customValidator.MatchPassword('password', 'confirmPassword'),
  }
  );

  ngOnInit(): void {
  }

  get updateProfileControl() {
    return this.updateProfileForm.controls;
  }

  get changePasswordControl() {
    return this.changePasswordForm.controls;
  }

  updateProfile(): void {
    this.submitted=true;
    if (this.updateProfileForm.valid) {
      this.userService.updateProfile({
        firstname:this.updateProfileControl.firstName.value,
        lastname:this.updateProfileControl.lastName.value,
        phone:this.updateProfileControl.phone.value
      });
      //TODO: Call API to register user and redirect to Login Page
    }
  }

  changePassword(){
    if (this.changePasswordForm.valid) {
      this.userService.changePassword(this.changePasswordControl.password.value);
    }
  }
}

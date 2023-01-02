
import { AbstractControl, ValidationErrors } from "@angular/forms";

export class CustomValidator {
  static passwordsMatching(control: AbstractControl): ValidationErrors | null {
        const password = control.get('password')?.value;
        const passwordConfirm = control.get('passwordConfirm')?.value;
        let error: any = { passwordsNotMatching: true };
        if ((password === passwordConfirm) && (password !== null && passwordConfirm !== null)) {
            error = null;
        }
        return error;
  }
}
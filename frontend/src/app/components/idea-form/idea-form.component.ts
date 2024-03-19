import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {IdeaService} from "../../services/idea.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-idea-form',
  templateUrl: './idea-form.component.html',
  styleUrls: ['./idea-form.component.css']
})
export class IdeaFormComponent {

  ideaForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private ideaService: IdeaService,
              private router: Router) {
    this.ideaForm = this.formBuilder.group({
      name: [null,Validators.required],
      descriptionOfIdea: [null,Validators.required]
    })
  }

  createIdea() {
    this.ideaService.createIdea(this.ideaForm.value).subscribe({})
  }
}

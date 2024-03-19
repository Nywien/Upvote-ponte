import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {IdeaFormDataModel} from "../models/ideaFormData.model";
import {Observable} from "rxjs";
import {IdeaListItemModel} from "../models/IdeaListItem.model";

const BASE_URL = "http://localhost:8080/api/ideas"

@Injectable({
  providedIn: 'root'
})
export class IdeaService {

  constructor(private httpClient: HttpClient) {
  }

  createIdea(ideaFormDataModel: IdeaFormDataModel): Observable<any> {
    return this.httpClient.post(BASE_URL, ideaFormDataModel);
  }

  getListIdeas(): Observable<Array<IdeaListItemModel>> {
    return this.httpClient.get<Array<IdeaListItemModel>>(BASE_URL);
  }
}

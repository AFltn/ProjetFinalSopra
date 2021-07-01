import { Utilisateur } from './utilisateur';
import { EditAvisComponent } from './../component/edit-avis/edit-avis.component';
import { Commande } from './commande';
import { Adresse } from './adresse';
import { Avis } from './avis';
export class Client {
  private _commandes: Commande[] = [];
  private _avis: Avis[] = [];

  constructor(
    private _id: number | any = null,
    private _nom: string = '',
    private _prenom: string = '',
    private _adresse: Adresse = new Adresse(),
    private _dateNaissance: Date = new Date(),
    private _mail: string = '',
    private _tel: string = '',
    private _utilisateur: Utilisateur | any = null
  ) {}

  /**
   * Getter avis
   * @return {Avis[] }
   */
  public get avis(): Avis[] {
    return this._avis;
  }

  /**
   * Setter avis
   * @param {Avis[] } value
   */
  public set avis(value: Avis[]) {
    this._avis = value;
  }

  /**
   * Getter utilisateur
   * @return {Utilisateur }
   */
  public get utilisateur(): Utilisateur {
    return this._utilisateur;
  }

  /**
   * Setter utilisateur
   * @param {Utilisateur } value
   */
  public set utilisateur(value: Utilisateur) {
    this._utilisateur = value;
  }

  /**
   * Getter commandes
   * @return {Commande[] }
   */
  public get commandes(): Commande[] {
    return this._commandes;
  }

  /**
   * Setter commandes
   * @param {Commande[] } value
   */
  public set commandes(value: Commande[]) {
    this._commandes = value;
  }

  /**
   * Getter mail
   * @return {string }
   */
  public get mail(): string {
    return this._mail;
  }

  /**
   * Setter mail
   * @param {string } value
   */
  public set mail(value: string) {
    this._mail = value;
  }

  /**
   * Getter tel
   * @return {string }
   */
  public get tel(): string {
    return this._tel;
  }

  /**
   * Setter tel
   * @param {string } value
   */
  public set tel(value: string) {
    this._tel = value;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string {
    return this._prenom;
  }

  /**
   * Getter adresse
   * @return {Adresse }
   */
  public get adresse(): Adresse {
    return this._adresse;
  }

  /**
   * Getter dateNaissance
   * @return {Date }
   */
  public get dateNaissance(): Date {
    return this._dateNaissance;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string) {
    this._prenom = value;
  }

  /**
   * Setter adresse
   * @param {Adresse } value
   */
  public set adresse(value: Adresse) {
    this._adresse = value;
  }

  /**
   * Setter dateNaissance
   * @param {Date } value
   */
  public set dateNaissance(value: Date) {
    this._dateNaissance = value;
  }
}

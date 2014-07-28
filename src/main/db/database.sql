--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2014-07-28 01:46:49 FET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "ProjectDataBase";
--
-- TOC entry 2077 (class 1262 OID 38409)
-- Name: ProjectDataBase; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "ProjectDataBase" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF8' LC_CTYPE = 'en_US.UTF8';


ALTER DATABASE "ProjectDataBase" OWNER TO postgres;

\connect "ProjectDataBase"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 188 (class 3079 OID 11769)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2080 (class 0 OID 0)
-- Dependencies: 188
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 201 (class 1255 OID 38410)
-- Name: logstudentstate(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION logstudentstate() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	if OLD.state <> NEW.state then
		insert into student_log (student_id,new_state,time) values (NEW.id,NEW.state,TIMESTAMP);
	end if;
	return NEW;
end;
$$;


ALTER FUNCTION public.logstudentstate() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 38411)
-- Name: curator; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE curator (
    id bigint NOT NULL
);

alter table public.curator add column studentsId enum not null ;
ALTER TABLE public.curator OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 38414)
-- Name: exadel_practice; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exadel_practice (
    stud_id bigint NOT NULL,
    curator character varying(255),
    interview character varying(255),
    on_probation boolean,
    practicestart timestamp without time zone,
    practicestop timestamp without time zone,
    workinvitation boolean
);


ALTER TABLE public.exadel_practice OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 38420)
-- Name: exadel_work; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exadel_work (
    stud_id bigint NOT NULL,
    billable boolean,
    billablestartdate timestamp without time zone,
    certificates character varying(255),
    curator character varying(255),
    currentproject character varying(255),
    currentprojectrole integer,
    exadeltrainingnextfrom timestamp without time zone,
    exadeltrainingnextto timestamp without time zone,
    exadeltrainingtype character varying(255),
    hoursdesiredtransferdate timestamp without time zone,
    hours_current integer,
    hours_desired integer,
    teamleadoncurrent character varying(255),
    vacationnextdateend timestamp without time zone,
    vacationnextdatestart timestamp without time zone,
    wannachangeproj boolean,
    workstartdate timestamp without time zone
);


ALTER TABLE public.exadel_work OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 38426)
-- Name: exadel_work_technology; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exadel_work_technology (
    exadel_work_stud_id bigint NOT NULL,
    projecttechnologies_id bigint NOT NULL
);


ALTER TABLE public.exadel_work_technology OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 38429)
-- Name: exam; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE exam (
    id bigint NOT NULL,
    course integer,
    grade double precision NOT NULL,
    summer boolean,
    stud_id bigint,
    student_fk bigint
);


ALTER TABLE public.exam OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 38432)
-- Name: feedback; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedback (
    id bigint NOT NULL,
    billablenow boolean,
    collectiverelations character varying(255),
    currentproject character varying(255),
    feedback character varying(255),
    feedbackdate timestamp without time zone,
    needmorehours boolean,
    profcompetence boolean,
    profmattersprogress character varying(255),
    workattitude character varying(255),
    author bigint,
    student_id bigint
);


ALTER TABLE public.feedback OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 38438)
-- Name: feedbackable; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedbackable (
    id bigint NOT NULL
);


ALTER TABLE public.feedbackable OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 38441)
-- Name: feedbacker; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE feedbacker (
    id bigint NOT NULL
);


ALTER TABLE public.feedbacker OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 38444)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 38446)
-- Name: joanna; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE joanna (
    id bigint NOT NULL
);


ALTER TABLE public.joanna OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 38449)
-- Name: skill; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE skill (
    id bigint NOT NULL,
    level character varying(255),
    type_id bigint
);


ALTER TABLE public.skill OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 38452)
-- Name: skill_type; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE skill_type (
    id bigint NOT NULL,
    type character varying(255)
);


ALTER TABLE public.skill_type OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 38455)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student (
    email character varying(255),
    english character varying(255),
    phone character varying(255),
    skype character varying(255),
    state character varying(255),
    course_group character varying(255),
    faculty character varying(255),
    graduate_year integer,
    specialty character varying(255),
    university character varying(255),
    id bigint NOT NULL
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 38461)
-- Name: student_log; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_log (
    new_state integer,
    "time" timestamp without time zone,
    student_id bigint,
    id integer NOT NULL
);


ALTER TABLE public.student_log OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 38464)
-- Name: student_log_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE student_log_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.student_log_id_seq OWNER TO postgres;

--
-- TOC entry 2081 (class 0 OID 0)
-- Dependencies: 184
-- Name: student_log_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE student_log_id_seq OWNED BY student_log.id;


--
-- TOC entry 185 (class 1259 OID 38466)
-- Name: student_skill; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student_skill (
    student_id bigint NOT NULL,
    skillset_id bigint NOT NULL
);


ALTER TABLE public.student_skill OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 38469)
-- Name: technology; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE technology (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.technology OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 38472)
-- Name: user_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_ (
    id bigint NOT NULL,
    first_name character varying(255),
    login character varying(255),
    pass character varying(255),
    second_name character varying(255),
    surname character varying(255)
);


ALTER TABLE public.user_ OWNER TO postgres;

--
-- TOC entry 1909 (class 2604 OID 38478)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_log ALTER COLUMN id SET DEFAULT nextval('student_log_id_seq'::regclass);


--
-- TOC entry 1911 (class 2606 OID 38480)
-- Name: curator_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY curator
    ADD CONSTRAINT curator_pkey PRIMARY KEY (id);


--
-- TOC entry 1913 (class 2606 OID 38482)
-- Name: exadel_practice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT exadel_practice_pkey PRIMARY KEY (stud_id);


--
-- TOC entry 1915 (class 2606 OID 38484)
-- Name: exadel_work_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_work
    ADD CONSTRAINT exadel_work_pkey PRIMARY KEY (stud_id);


--
-- TOC entry 1917 (class 2606 OID 38486)
-- Name: exadel_work_technology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_work_technology
    ADD CONSTRAINT exadel_work_technology_pkey PRIMARY KEY (exadel_work_stud_id, projecttechnologies_id);


--
-- TOC entry 1919 (class 2606 OID 38488)
-- Name: exadel_work_technology_projecttechnologies_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exadel_work_technology
    ADD CONSTRAINT exadel_work_technology_projecttechnologies_id_key UNIQUE (projecttechnologies_id);


--
-- TOC entry 1921 (class 2606 OID 38490)
-- Name: exam_course_stud_id_summer_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT exam_course_stud_id_summer_key UNIQUE (course, stud_id, summer);


--
-- TOC entry 1923 (class 2606 OID 38492)
-- Name: exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


--
-- TOC entry 1925 (class 2606 OID 38494)
-- Name: feedback_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);


--
-- TOC entry 1927 (class 2606 OID 38496)
-- Name: feedbackable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedbackable
    ADD CONSTRAINT feedbackable_pkey PRIMARY KEY (id);


--
-- TOC entry 1929 (class 2606 OID 38498)
-- Name: feedbacker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY feedbacker
    ADD CONSTRAINT feedbacker_pkey PRIMARY KEY (id);


--
-- TOC entry 1931 (class 2606 OID 38500)
-- Name: joanna_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY joanna
    ADD CONSTRAINT joanna_pkey PRIMARY KEY (id);


--
-- TOC entry 1933 (class 2606 OID 38502)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 1935 (class 2606 OID 38504)
-- Name: skill_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY skill_type
    ADD CONSTRAINT skill_type_pkey PRIMARY KEY (id);


--
-- TOC entry 1937 (class 2606 OID 38506)
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);


--
-- TOC entry 1939 (class 2606 OID 38508)
-- Name: student_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT student_skill_pkey PRIMARY KEY (student_id, skillset_id);


--
-- TOC entry 1941 (class 2606 OID 38510)
-- Name: student_skill_skillset_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT student_skill_skillset_id_key UNIQUE (skillset_id);


--
-- TOC entry 1943 (class 2606 OID 38512)
-- Name: technology_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY technology
    ADD CONSTRAINT technology_pkey PRIMARY KEY (id);


--
-- TOC entry 1945 (class 2606 OID 38514)
-- Name: user__login_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__login_key UNIQUE (login);


--
-- TOC entry 1947 (class 2606 OID 38516)
-- Name: user__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__pkey PRIMARY KEY (id);


--
-- TOC entry 1965 (class 2620 OID 38604)
-- Name: onchangestate; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER onchangestate AFTER UPDATE OF state ON student FOR EACH ROW EXECUTE PROCEDURE logstudentstate();


--
-- TOC entry 1953 (class 2606 OID 38518)
-- Name: fk2fb81f7cd24bf0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT fk2fb81f7cd24bf0 FOREIGN KEY (stud_id) REFERENCES student(id);


--
-- TOC entry 1954 (class 2606 OID 38523)
-- Name: fk2fb81faf4a622f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exam
    ADD CONSTRAINT fk2fb81faf4a622f FOREIGN KEY (student_fk) REFERENCES student(id);


--
-- TOC entry 1949 (class 2606 OID 38528)
-- Name: fk33666ffd7cd24bf0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_practice
    ADD CONSTRAINT fk33666ffd7cd24bf0 FOREIGN KEY (stud_id) REFERENCES student(id);


--
-- TOC entry 1960 (class 2606 OID 38533)
-- Name: fk686ca51c0ce7d56; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT fk686ca51c0ce7d56 FOREIGN KEY (type_id) REFERENCES skill_type(id);


--
-- TOC entry 1959 (class 2606 OID 38538)
-- Name: fk849091851d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY joanna
    ADD CONSTRAINT fk849091851d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1962 (class 2606 OID 38543)
-- Name: fk8c59bf40af4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_log
    ADD CONSTRAINT fk8c59bf40af4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1961 (class 2606 OID 38548)
-- Name: fk8ffe823bbe0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student
    ADD CONSTRAINT fk8ffe823bbe0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 1958 (class 2606 OID 38553)
-- Name: fk9d9b07121d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedbacker
    ADD CONSTRAINT fk9d9b07121d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1950 (class 2606 OID 38558)
-- Name: fk9f1e66d37cd24bf0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_work
    ADD CONSTRAINT fk9f1e66d37cd24bf0 FOREIGN KEY (stud_id) REFERENCES student(id);


--
-- TOC entry 1957 (class 2606 OID 38563)
-- Name: fka2e4fe9fbe0c9048; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedbackable
    ADD CONSTRAINT fka2e4fe9fbe0c9048 FOREIGN KEY (id) REFERENCES user_(id);


--
-- TOC entry 1948 (class 2606 OID 38568)
-- Name: fka65cd3761d958e15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY curator
    ADD CONSTRAINT fka65cd3761d958e15 FOREIGN KEY (id) REFERENCES feedbackable(id);


--
-- TOC entry 1951 (class 2606 OID 38573)
-- Name: fkd508de18719f5918; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_work_technology
    ADD CONSTRAINT fkd508de18719f5918 FOREIGN KEY (projecttechnologies_id) REFERENCES technology(id);


--
-- TOC entry 1952 (class 2606 OID 38578)
-- Name: fkd508de18f224ff01; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY exadel_work_technology
    ADD CONSTRAINT fkd508de18f224ff01 FOREIGN KEY (exadel_work_stud_id) REFERENCES exadel_work(stud_id);


--
-- TOC entry 1963 (class 2606 OID 38583)
-- Name: fkdd47d74daf4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT fkdd47d74daf4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1964 (class 2606 OID 38588)
-- Name: fkdd47d74deb8ca365; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY student_skill
    ADD CONSTRAINT fkdd47d74deb8ca365 FOREIGN KEY (skillset_id) REFERENCES skill(id);


--
-- TOC entry 1955 (class 2606 OID 38593)
-- Name: fkf495eb85af4a6285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fkf495eb85af4a6285 FOREIGN KEY (student_id) REFERENCES student(id);


--
-- TOC entry 1956 (class 2606 OID 38598)
-- Name: fkf495eb85c9c2a285; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY feedback
    ADD CONSTRAINT fkf495eb85c9c2a285 FOREIGN KEY (author) REFERENCES feedbackable(id);


--
-- TOC entry 2079 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-07-28 01:46:49 FET

--
-- PostgreSQL database dump complete
--

